package com.heyh.valid.jvm.classLoad.classLoadOrder;

public class Grandpa {

    static {
        System.out.println("爷爷在静态代码块！");
    }

}
