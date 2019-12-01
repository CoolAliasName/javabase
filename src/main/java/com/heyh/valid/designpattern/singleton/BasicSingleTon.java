package com.heyh.valid.designpattern.singleton;

/**
 * 饿汉模式
 */
public class BasicSingleTon {

    // 创建唯一实例
    private static BasicSingleTon basicSingleTon = new BasicSingleTon();

    // 对外暴露静态方法返回唯一实例
    public static BasicSingleTon getBasicSingleTon() {
        return basicSingleTon;
    }

    private BasicSingleTon() {

    }

}
