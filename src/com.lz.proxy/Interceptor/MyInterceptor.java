package com.lz.proxy.Interceptor;

import java.lang.reflect.Method;

public class MyInterceptor implements Interceptor {
    @Override
    public boolean before(Object proxy, Object target, Method method, Object args) {
        System.err.println("反射方法前逻辑");
        return false;
    }

    @Override
    public boolean around(Object proxy, Object target, Method method, Object args) {
        System.err.println("取代了被代理对象的方法");
        return false;
    }

    @Override
    public boolean after(Object proxy, Object target, Method method, Object args) {
        System.err.println("反射方法后逻辑");
        return false;
    }
}
