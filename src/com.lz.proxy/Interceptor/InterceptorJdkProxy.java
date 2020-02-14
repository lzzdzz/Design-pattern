package com.lz.proxy.Interceptor;

import com.lz.proxy.HelloWorld;
import com.lz.proxy.HelloWorldImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class InterceptorJdkProxy implements InvocationHandler {

    //真实对象
    private Object target;
    //拦截器全限定名
    private String interceptorClass = null;

    public InterceptorJdkProxy(Object target,String interceptorClass){
        this.target = target;
        this.interceptorClass = interceptorClass;
    }

    /**
     * 绑定委托对象并返回一个代理占位
     * @param target 真实对象
     * @param interceptorClass 拦截器全限定名
     * @return 代理对象占位
     * @throws Throwable
     */
    public static Object bind(Object target,String interceptorClass)throws Throwable{
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),new InterceptorJdkProxy(target,interceptorClass));
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if(interceptorClass == null){
            //没有设置拦截器则直接反射原有方法
            return method.invoke(target,args);
        }
        Object result = null;
        //通过反射生成拦截器
        Interceptor interceptor = (Interceptor) Class.forName(interceptorClass).newInstance();
        //调用前置方法
        if (interceptor.before(proxy,target,method,args)){
            //反射原有对象方法
            result = method.invoke(target,args);
        }else{//返回false执行around方法
            interceptor.around(proxy,target,method,args);
        }
        interceptor.after(proxy,target,method,args);
        return result;
    }

    public static void main(String[] args) {
        try {
            HelloWorld proxy = (HelloWorld) InterceptorJdkProxy.bind(new HelloWorldImpl(),"com.lz.proxy.Interceptor.MyInterceptor");
            proxy.sayHelloWorld();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
}
