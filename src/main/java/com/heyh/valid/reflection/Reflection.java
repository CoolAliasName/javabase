package com.heyh.valid.reflection;

import com.heyh.valid.reflection.bean.ExtendType;
import com.heyh.valid.reflection.proxy.DynamicSubject;
import com.heyh.valid.reflection.proxy.RealSubject;
import com.heyh.valid.reflection.proxy.Subject;

import java.lang.reflect.*;

public class Reflection {

    public static void main(String[] args) {
//        getfiles();

//        System.out.println();
//        getMethods();

//        System.out.println();
//        getConstructor();

//        System.out.println();
//        getInstance();

//        System.out.println();
//        getInvoke();

//        System.out.println();
//        setField();

        System.out.println();
        setProxy();
    }

    /**
     * 获取对象属性方法有两种，
     * getFields(), 返回指定类及其父类申明的 public 属性
     * getDeclaredFields(), 返回指定类全部属性，不包括父类
     */
    public static void getfiles() {
        Class<?> classType = ExtendType.class;

        Field[] fields = classType.getFields();
        for (Field field: fields) {
            System.out.println(field);
        }
        System.out.println("----------------------------------------------");

        fields = classType.getDeclaredFields();
        for (Field field: fields) {
            System.out.println(field);
        }
    }

    /**
     * 获取类方法
     */
    public static void getMethods() {
        Class<?> clazz = ExtendType.class;
        Method[] methods = clazz.getMethods();
        for (Method method: methods) {
            System.out.println(method);
        }
        System.out.println("----------------------------------------------");

        methods = clazz.getDeclaredMethods();
        for (Method method: methods) {
            System.out.println(method);
        }
    }

    /**
     * 获取类构造器
     */
    public static void getConstructor() {
        Class<?> clazz = ExtendType.class;
        Constructor<?>[] constructors = clazz.getConstructors();
        for (Constructor constructor: constructors) {
            System.out.println(constructor);
        }
        System.out.println("----------------------------------------------");

        Constructor<?>[] constructors2 = clazz.getDeclaredConstructors();
        for (Constructor constructor: constructors2) {
            System.out.println(constructor);
        }
    }

    /**
     * 通过反射获取类实例
     */
    public static void getInstance() {
        try {
            Class<?> clazz = ExtendType.class;
            Object newInstance = clazz.newInstance();
            System.out.println(newInstance);
            System.out.println("----------------------------------------------");

            Constructor<?> constructor = clazz.getConstructor();
            Object newInstance2 = constructor.newInstance();
            System.out.println(newInstance2);
            System.out.println("----------------------------------------------");

            Constructor<?> constructor2 = clazz.getDeclaredConstructor(int.class, String.class);
            constructor2.setAccessible(true); // ExtendType的有参构造函数不是public的，因此在这里没有访问权限，通过setAccessible()增加权限
            newInstance = constructor2.newInstance(1, "123");
            System.out.println(newInstance);
            System.out.println("----------------------------------------------");
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    /**
     * 通过反射调用函数
     */
    public static void getInvoke() {
        try {
            Class<?> classType = ExtendType.class;
            Object inst = classType.newInstance();
            Method logMethod = classType.getDeclaredMethod("Log", String.class);
            logMethod.setAccessible(true);
            logMethod.invoke(inst, "test");
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    /**
     * 通过反射set属性
     */
    public static void setField() {
        try {
            Class<?> clazz = ExtendType.class;
            Object newInstance = clazz.newInstance();
            Field pubIntExtendField = clazz.getField("pubIntExtendField");
            pubIntExtendField.setInt(newInstance, 100);
            int value = pubIntExtendField.getInt(newInstance);
            System.out.println("value: " + value);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    /**
     * 构建动态代理对象
     */
    public static void setProxy() {
        RealSubject realSubject = new RealSubject();
        InvocationHandler handler = new DynamicSubject(realSubject);
        Class<?> clazz = handler.getClass();
        Subject subject = (Subject) Proxy.newProxyInstance(clazz.getClassLoader(),
                realSubject.getClass().getInterfaces(), handler);
        System.out.println(subject.getClass());

        // 通过调用代理对象的方法去调用真实角色的方法
        subject.request();
        System.out.println(subject.query("123"));
    }

}