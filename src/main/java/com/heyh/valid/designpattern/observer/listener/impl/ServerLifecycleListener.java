package com.heyh.valid.designpattern.observer.listener.impl;

import com.heyh.valid.designpattern.observer.util.LifecycleEvent;
import com.heyh.valid.designpattern.observer.listener.LifecycleListener;

/**
 * 具体的观察者
 * 实现了 LifecycleListener 接口的方法，就是这个具体的观察者具体的实现方式
 */
public class ServerLifecycleListener implements LifecycleListener {

    @Override
    public void lifecycleEvent(LifecycleEvent event) {
        if (event.getType().equals("server")) {
            System.out.println("这里是观察者 ServerLifecycleListener...");
        }
    }

}
