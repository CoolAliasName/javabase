package com.heyh.valid.thread.junior.baseMethod;

/**
 * join方法的阻塞实现
 */
public class JoinDemo extends Thread {

    int i;
    Thread previousThread; // 上一个线程

    public JoinDemo(int i, Thread previousThread) {
        this.i = i;
        this.previousThread = previousThread;
    }

    @Override
    public void run() {
        try {
            previousThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("num: " + i);
//        System.out.println(previousThread.isAlive());
    }

    public static void main(String[] args) {

        Thread previousThread = Thread.currentThread(); // 主线程 public static void main(String[] args) {
//        System.out.println("first: " + previousThread.isAlive());
        for (int i = 0; i < 10; i++) {
            System.out.println("current: " + previousThread.getName());
            JoinDemo joinDemo = new JoinDemo(i, previousThread);
            joinDemo.start();
//            System.out.println(i + ", " + previousThread.isAlive());
            previousThread = joinDemo; // 获取每个线程的前一个线程
        }

    }

}