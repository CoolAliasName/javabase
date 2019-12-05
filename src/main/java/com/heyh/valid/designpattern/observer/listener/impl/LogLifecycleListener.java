package com.heyh.valid.designpattern.observer.listener.impl;

import com.heyh.valid.designpattern.observer.util.LifecycleEvent;
import com.heyh.valid.designpattern.observer.listener.LifecycleListener;

public class LogLifecycleListener implements LifecycleListener {

    @Override
    public void lifecycleEvent(LifecycleEvent event) {
        if (event.getType().equals("log")) {
            System.out.println("这里是观察者 LogLifecycleListener...");
        }
    }

}
