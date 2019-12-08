package com.heyh.valid.designpattern.duty.pipeline;

/**
 * 定义阀门接口
 * 管道是链表，阀门就是链表上的一个个节点，这里与 HashMap 不同，节点不是以内部类的形式出现
 */
public interface Valve {

    public Valve getNext();
    public void setNext(Valve valve);
    public void invoke();

}
