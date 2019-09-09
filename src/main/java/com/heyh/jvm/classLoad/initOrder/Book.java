package com.heyh.jvm.classLoad.initOrder;

public class Book {

    public static void main(String[] args) {
        Book book = new Book();
        System.out.println("Hello World!");
    }

    int price = 110;

    {
        System.out.println("Book的普通代码块");
    }

    static int amount = 112;

    static {
        System.out.println("Book的静态代码块");
    }

    Book() {
        System.out.println("Book的构造方法");
        System.out.println("price = " + price + ", amount = " + amount);
    }

}
