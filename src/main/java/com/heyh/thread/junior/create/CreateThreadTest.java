package com.heyh.thread.junior.create;

public class CreateThreadTest {

    public static void main(String[] args) {

        // 继承 Thread
        /*TicketExtends ticketExtends1 = new TicketExtends("zhangsan");
        TicketExtends ticketExtends2 = new TicketExtends("lisi");

        ticketExtends1.start();
        ticketExtends2.start();*/


        // 实现 Runnable 接口
        TicketImpl ticket = new TicketImpl();

        Thread thread1 = new Thread(ticket);
        Thread thread2 = new Thread(ticket);

        thread1.start();
        thread2.start();
    }

}
