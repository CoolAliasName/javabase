package com.heyh.jvm.classLoad.classAndObjLoadOrder;

public class Father extends Grandpa {

    static {
        System.out.println("爸爸在静态代码块");
    }

    public Father() {
        System.out.println("我是爸爸");
    }

}
