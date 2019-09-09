package com.heyh.thread.junior.consumerandproducter.blockingqueue;

/**
 * 商品
 */
public class Product {

    private int id;
    final static int MAX = 10;

    public Product(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
