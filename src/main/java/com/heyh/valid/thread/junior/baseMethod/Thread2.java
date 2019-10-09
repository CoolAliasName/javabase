package com.heyh.valid.thread.junior.baseMethod;

public class Thread2 extends Thread{

    Thread thread;

    public Thread2(String name, Thread thread) {
        super(name);
        this.thread = thread;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(getName() + ", " + i);
        }
    }

    public static void main(String[] args) {
        Thread1 thread1 = new Thread1("thread1");
        Thread2 thread2 = new Thread2("thread2", thread1);
        thread2.start();
        thread1.start();
    }

}
