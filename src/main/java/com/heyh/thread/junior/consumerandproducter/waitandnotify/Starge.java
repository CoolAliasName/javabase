package com.heyh.thread.junior.consumerandproducter.waitandnotify;

/**
 * 仓库类
 */
public class Starge {

    private int MAX_SIZE = 20;
    private int count = 0;

    /**
     * 消费者进行消费
     */
    public synchronized void consum() {
        while (this.count == 0) {
            try {
                System.out.println("[ 消费者 ] 库存为空了，暂时无法进行消费...");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.count--;
        System.out.println("[ 消费者 ] " + Thread.currentThread().getName() + "消费产品，当前库存为：" + count);
        notify();
    }

    public synchronized void produce() {
        while (count == MAX_SIZE) {
            try {
                System.out.println("[ 生产者 ] 库存已满，暂时不进行生产...");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.count++;
        System.out.println("[ 生产者 ] " + Thread.currentThread().getName() + "生产产品，库存为：" + count);
        notify();
    }

}
