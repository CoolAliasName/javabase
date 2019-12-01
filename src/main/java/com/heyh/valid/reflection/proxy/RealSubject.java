package com.heyh.valid.reflection.proxy;

/**
 * 定义真是角色
 */
public class RealSubject implements Subject {

    @Override
    public void request() {
        System.out.println("RealSubject!");
    }

    @Override
    public String query(String id) {
        return "this query result is " + id + " -001";
    }

}
