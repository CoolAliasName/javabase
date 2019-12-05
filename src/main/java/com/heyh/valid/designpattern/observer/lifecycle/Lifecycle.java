package com.heyh.valid.designpattern.observer.lifecycle;

/**
 * 抽象主题
 * 定义了管理观察者的方法和它要所做的其它方法
 */
public interface Lifecycle {

    public void start();
    public void stop();

}