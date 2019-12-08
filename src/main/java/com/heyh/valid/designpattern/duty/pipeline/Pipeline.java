package com.heyh.valid.designpattern.duty.pipeline;

/**
 * 抽象管道
 */
public interface Pipeline {

    public Valve getFirst();
    public Valve getBasic();
    public void setBasic(Valve valve);
    public void addValve(Valve valve);

}
