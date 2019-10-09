package com.heyh.valid.thread.junior;

public class MyThread {

    public static void main(String[] args) {
        try {
            Thread t = new Thread();
            t.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
                @Override
                public void uncaughtException(Thread t, Throwable e) {
                    System.out.println("catch到了...");
                }
            });
            t.start();
        } catch (Exception e) {
            System.out.println("catch不到...");
        }
    }

}