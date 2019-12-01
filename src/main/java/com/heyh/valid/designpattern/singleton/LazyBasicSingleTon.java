package com.heyh.valid.designpattern.singleton;

/**
 * 懒汉模式
 */
public class LazyBasicSingleTon {

    // 唯一实例在初始化阶段不会被赋值，要等对外暴露的静态方法被调用
    private static LazyBasicSingleTon lazyBasicSingleTon = null;

    public static LazyBasicSingleTon getInstance() {
        //延迟初始化 在第一次调用 getInstance 的时候创建对象
        if (lazyBasicSingleTon == null) {
            return lazyBasicSingleTon = new LazyBasicSingleTon();
        }
        return lazyBasicSingleTon;
    }

    private LazyBasicSingleTon() {
    }

}
