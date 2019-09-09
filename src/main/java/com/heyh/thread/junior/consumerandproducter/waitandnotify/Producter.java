package com.heyh.thread.junior.consumerandproducter.waitandnotify;

/**
 * 生产者
 */
public class Producter implements Runnable{

    private Starge starge;

    public Producter(Starge starge) {
        this.starge = starge;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            starge.produce();
        }
    }
}
