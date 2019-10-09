package com.heyh.valid.thread.junior.create;

import com.heyh.valid.thread.junior.create.TicketExtends;
import org.junit.Test;

public class ThreadCreateTest {

    @Test
    public void test1() {
        TicketExtends ticketExtends = new TicketExtends("zhangsan");

        ticketExtends.start();
    }

}
