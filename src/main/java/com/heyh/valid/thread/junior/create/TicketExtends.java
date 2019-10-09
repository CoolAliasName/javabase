package com.heyh.valid.thread.junior.create;

public class TicketExtends extends Thread {

    private static int ticks = 10; // 静态变量，保证多个线程操作的都是同一个 tickes

    public TicketExtends(String name) {
        super(name);
    }

    @Override
    public void run() {
        while (true) {
            if (ticks > 0) {
                System.out.println(this.getName() + "------" + ticks--);
            }
        }
    }
}
