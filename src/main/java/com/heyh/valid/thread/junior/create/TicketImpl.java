package com.heyh.valid.thread.junior.create;

public class TicketImpl implements Runnable {

    private static int ticks = 10; // 静态变量，保证多个线程操作的都是同一个 tickes

    @Override
    public void run() {
        while (true) {
            if (ticks > 0) {
                System.out.println(Thread.currentThread().getName() + "-------" + ticks--);
            }
        }
    }
}
