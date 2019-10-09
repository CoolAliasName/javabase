package com.heyh.valid.jvm.classLoad.staticNewOrder;

public class Book {

    public static void main(String[] args) {
        staticFunction();
    }

    static Book book = new Book();

    static {
        System.out.println("书的静态代码块");
    }

    public static void staticFunction() {
        System.out.println("书的静态方法");
    }

    static int amount = 112;

    int price = 110;

    {
        System.out.println("书的普通代码块");
    }

    public Book() {
        System.out.println("书的构造方法");
        System.out.println("price: " + price + ", amount: " + amount);
    }

}
