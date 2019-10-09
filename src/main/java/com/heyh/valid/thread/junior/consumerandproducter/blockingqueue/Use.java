package com.heyh.valid.thread.junior.consumerandproducter.blockingqueue;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Use {

    public static void main(String[] args) {
        Storage storage = new Storage();

        ExecutorService pool = Executors.newCachedThreadPool();

        Producer producer = new Producer("生产者一号", storage);
        Consumer consumer = new Consumer("消费者一号", storage);

        pool.submit(producer);
        pool.submit(consumer);

        pool.shutdown();



    }

}
