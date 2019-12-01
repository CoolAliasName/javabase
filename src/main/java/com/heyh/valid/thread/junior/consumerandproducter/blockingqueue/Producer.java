package com.heyh.valid.thread.junior.consumerandproducter.blockingqueue;

/**
 * 生产者
 * 阻塞队列模式下的生产者不需要考虑生产者何时不生产，只管一直生产下去
 * 何时生产何时休息，即把线程的wait notify(等待唤醒)交给了 BlockinQqueque 阻塞队列
 */
public class Producer implements Runnable {

    private String name;
    private Storage storage;

    public Producer(String name, Storage storage) {
        this.name = name;
        this.storage = storage;
    }

    @Override
    public void run() {
        int i = 0;
        try {
            while (true) {
                System.out.println(name + "已经生产了一个 id 为: " + i + "的商品");
                System.out.println("---------------------------------------");

                Product product = new Product(i++);
                storage.push(product);

                Thread.sleep(100);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
