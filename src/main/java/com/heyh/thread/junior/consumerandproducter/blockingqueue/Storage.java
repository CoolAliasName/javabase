package com.heyh.thread.junior.consumerandproducter.blockingqueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 仓库
 * 仓库通过 BlockingQueue 阻塞队列实现
 * 仓库负责存入商品和拿出商品
 */
public class Storage {

    private BlockingQueue<Product> queue = new LinkedBlockingQueue<>(Product.MAX);

    public void push(Product product) throws InterruptedException {
        queue.put(product);
    }

    public Product pull() throws InterruptedException {
        return queue.take();
    }


}
