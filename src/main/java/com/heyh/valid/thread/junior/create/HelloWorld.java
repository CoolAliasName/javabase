package com.heyh.valid.thread.junior.create;

public class HelloWorld {

    public static void main(String[] args) {
        Thread t = new Thread() {
            @Override
            public void run() {
                world();
            }
        };

        t.start();
//        t.run();

        System.out.print(" Hello ");
    }

    public static void world() {
        System.out.print(" World ");
    }

}
