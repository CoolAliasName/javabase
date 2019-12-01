package com.heyh.valid.reflection.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 代理角色
 */
public class DynamicSubject implements InvocationHandler {

    private Object subject;

    public DynamicSubject(Object obj) {
        this.subject = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Method: " + method + ", Args: " + args);
        return method.invoke(subject, args);
//        return null;
    }

}
