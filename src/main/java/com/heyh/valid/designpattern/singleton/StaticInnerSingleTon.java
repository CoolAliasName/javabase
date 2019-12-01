package com.heyh.valid.designpattern.singleton;

/**
 * 内部类实现单例
 * 内部类本身是线程安全的，因此该方式多线程下无需再做其他处理
 */
public class StaticInnerSingleTon {

    private static class StaticInnerClass {
        private static StaticInnerSingleTon staticInnerSingleTon = new StaticInnerSingleTon();
    }

    public StaticInnerSingleTon getInstance() {
        // 引用一个类的静态成员，将会触发该类的初始化 符合规则1
        return StaticInnerClass.staticInnerSingleTon;
    }

    private StaticInnerSingleTon() {

    }

}
