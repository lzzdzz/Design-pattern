package com.lz.reflect;

import java.lang.reflect.InvocationTargetException;

/*
*反射对象，有构造参数时
*/
public class ReflectServiceImpl2 {
    private String name;
    public ReflectServiceImpl2(String name){
        this.name = name;
    }
    public void sayHello(String name){
        System.out.println("Hello"+name);
    }

    public ReflectServiceImpl2 getInstance(){
        ReflectServiceImpl2 object = null;
        try {
            try {
                object = (ReflectServiceImpl2) Class.forName("main.java.com.lz.reflect").getConstructor(String.class).newInstance("张三");
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return object;
    }
}
