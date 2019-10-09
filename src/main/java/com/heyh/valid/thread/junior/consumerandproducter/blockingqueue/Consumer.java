package com.heyh.valid.thread.junior.consumerandproducter.blockingqueue;

public class Consumer implements Runnable {

    private String name;
    private Storage storage;

    public Consumer(String name, Storage storage) {
        this.name = name;
        this.storage = storage;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Product product = storage.pull();

                System.out.println(name + "已经消费一个 id 为: " + product.getId() + "的商品");
                System.out.println("----------------------------------------------------");

                Thread.sleep(500);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
