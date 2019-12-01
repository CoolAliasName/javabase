package com.heyh.valid.designpattern.singleton;

/**
 * 多线程单例
 * 双重判空
 */
public class DCLBasicSingleTon {

    private static DCLBasicSingleTon dclBasicSingleTon = null;

    public static DCLBasicSingleTon getInstance() {
        //这次判空是避免了，保证多线程只有第一次调用 getInstance 的时候才会加锁初始化
        if (dclBasicSingleTon == null) {
            synchronized (DCLBasicSingleTon.class) {
                if (dclBasicSingleTon == null) {
                    return dclBasicSingleTon = new DCLBasicSingleTon();
                }
            }
        }
        return dclBasicSingleTon;
    }

    private DCLBasicSingleTon() {

    }

}