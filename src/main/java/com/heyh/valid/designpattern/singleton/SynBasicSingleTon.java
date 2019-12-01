package com.heyh.valid.designpattern.singleton;

/**
 * 多线程下的单例
 */
public class SynBasicSingleTon {

    private static SynBasicSingleTon synBasicSingleTon = null;

    /** 使用 synchronized 保证线程在创建对象的时候让其他线程阻塞*/
//    public synchronized static SynBasicSingleTon getInstance() {
//        if (synBasicSingleTon == null) {
//            return synBasicSingleTon = new SynBasicSingleTon();
//        }
//        return synBasicSingleTon;
//    }

    /** synchronized 关键字也可以加在判空操作上,这样本质上与上面的方案并没有区别 */
    public static SynBasicSingleTon getInstance() {
        synchronized (SynBasicSingleTon.class) {
            if (synBasicSingleTon == null) {
                return synBasicSingleTon = new SynBasicSingleTon();
            }
        }
        return synBasicSingleTon;
    }


    private SynBasicSingleTon() {

    }

}
