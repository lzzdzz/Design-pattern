package com.lz.reflect;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/*
*      反射：用来解除耦合
*/
public class ReflectServiceImpl {
    /*任意的测试方法*/
    public void sayHello(String name){
        System.out.println("Hello"+name);
    }

    /*反射对象*/
    public ReflectServiceImpl getInstance(){
        ReflectServiceImpl object = null;
        try {
            object = (ReflectServiceImpl) Class.forName("com.lz.reflect.ReflectServiceImpl").newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return object;
    }
    /*已知对象时，反射方法*/
    public Object reflectMenthod(){
        Object returnObj = null;
        ReflectServiceImpl target = new ReflectServiceImpl();
        try {
            /*Method method = ReflectServiceImpl.class.getMethod("sayHello", String.class);
            returnObj = method.invoke(target,"张三");*/
            Method method = target.getClass().getMethod("sayHello", String.class);
            returnObj = method.invoke(target,"张三");
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return returnObj;
    }

    /*反射对象和反射方法*/
    public Object reflect(){
        Object object = null;
        ReflectServiceImpl target = null;
        try {
            target = (ReflectServiceImpl) Class.forName("com.lz.reflect.ReflectServiceImpl").newInstance();
            /*Method method = target.getClass().getMethod("sayHello", String.class);
            method.invoke(target,"张三");*/
            Method method = ReflectServiceImpl.class.getMethod("sayHello", String.class);
            method.invoke(target,"张三");
        } catch (InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return object;
    }
}
