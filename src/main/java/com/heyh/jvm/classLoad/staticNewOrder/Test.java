package com.heyh.jvm.classLoad.staticNewOrder;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
        System.out.println("test的构造方法");
    }

    {
        System.out.println("test的代码块");
    }

}
