package com.heyh.valid.designpattern.singleton;

/**
 * 多线程单例
 * 避免指令重排 Volatile
 */
public class VolatileSingleTon {

    //使用 Volatile 保证了指令重排序在这个对象创建的时候不可用
    private static volatile VolatileSingleTon volatileSingleTon = null;

    public static VolatileSingleTon getInstance() {
        if (volatileSingleTon == null) {
            synchronized (VolatileSingleTon.class) {
                if (volatileSingleTon == null) {
                    return volatileSingleTon = new VolatileSingleTon();
                }
            }
        }
        return volatileSingleTon;
    }

    private VolatileSingleTon() {

    }

}
