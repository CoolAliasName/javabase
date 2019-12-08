package com.heyh.valid.designpattern.duty.pipeline;

/**
 * 具体阀门类实现
 */
public class MyValve1 implements Valve {

    public Valve next = null;

    @Override
    public Valve getNext() {
        return this.next;
    }

    @Override
    public void setNext(Valve valve) {
        this.next = valve;
    }

    @Override
    public void invoke() {
            System.out.println("1...........");
        if (this.next == null) {
            System.out.println("责任链结束.....");
        } else {
            getNext().invoke();
        }
        return;
    }
}
