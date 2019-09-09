package com.heyh.thread.junior.consumerandproducter.waitandnotify;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Use {

    public static void main(String[] args) {
        Starge starge = new Starge();
        ExecutorService pool = Executors.newCachedThreadPool();

        for (int i = 0; i < 5; i++) {
            pool.submit(new Producter(starge));
        }

        for (int i = 0; i < 5; i++) {
            pool.submit(new Consumer(starge));
        }

        pool.shutdown();
    }
}