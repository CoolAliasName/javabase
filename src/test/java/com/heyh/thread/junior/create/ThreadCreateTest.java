package com.heyh.thread.junior.create;

import org.junit.Test;

public class ThreadCreateTest {

    @Test
    public void test1() {
        TicketExtends ticketExtends = new TicketExtends("zhangsan");

        ticketExtends.start();
    }

}
