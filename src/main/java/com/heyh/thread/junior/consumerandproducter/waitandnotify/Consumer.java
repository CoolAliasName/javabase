package com.heyh.thread.junior.consumerandproducter.waitandnotify;

/**
 * 消费者
 */
public class Consumer implements Runnable {

    private Starge starge;

    public Consumer(Starge starge) {
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
            starge.consum();
        }
    }
}