package com.heyh.jvm.classLoad.classAndObjLoadOrder;

public class Grandpa {

    static {
        System.out.println("爷爷在静态代码块");
    }

    public Grandpa() {
        System.out.println("我是爷爷");
    }

}
