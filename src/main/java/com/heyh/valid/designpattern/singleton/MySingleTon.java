package com.heyh.valid.designpattern.singleton;

/**
 * 单例模式场景应用（懒汉模式）
 * 多聚合根处理
 */
public class MySingleTon {

    private String name;
    private String code;

    // 唯一实例在初始化阶段不会被赋值，要等对外暴露的静态方法被调用
    private static MySingleTon mySingleTon = null;

    public static MySingleTon getInstance() {
        return getInstance(null, null);
    }

    public static MySingleTon getInstance(String name, String code) {
        //延迟初始化 在第一次调用 getInstance 的时候创建对象
        if (mySingleTon == null) {
            return mySingleTon = new MySingleTon(name, code);
        }
        return mySingleTon;
    }

    public void changeName(String name) {
        this.name = name;
    }

    private MySingleTon(String name, String code) {
        this.name = name;
        this.code = code;
    }

    @Override
    public String toString() {
        return this.name + ": " + this.code;
    }
}
