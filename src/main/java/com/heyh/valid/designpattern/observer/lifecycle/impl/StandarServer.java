package com.heyh.valid.designpattern.observer.lifecycle.impl;

import com.heyh.valid.designpattern.observer.listener.LifecycleListener;
import com.heyh.valid.designpattern.observer.listener.impl.LogLifecycleListener;
import com.heyh.valid.designpattern.observer.lifecycle.Lifecycle;
import com.heyh.valid.designpattern.observer.listener.impl.ServerLifecycleListener;
import com.heyh.valid.designpattern.observer.util.LifecycleEvent;
import com.heyh.valid.designpattern.observer.util.LifecycleSupport;

import java.util.ArrayList;
import java.util.List;

/**
 * 具体主题
 * 实现了抽象主题的所有方法
 */
public class StandarServer implements Lifecycle {

    private LifecycleSupport support = new LifecycleSupport();
    private List<LifecycleListener> lifecycleListeners = new ArrayList<>();

    public void addLifecycleListeners(LifecycleListener lifecycleListener) {
        lifecycleListeners.add(lifecycleListener);
    }

    @Override
    public void start() {
        LifecycleListener listener = new LogLifecycleListener();
        this.addLifecycleListeners(listener);
        System.out.println("start!");
        this.fireLifecycleEvent("log", null);
    }

    @Override
    public void stop() {
        LifecycleListener listener = new ServerLifecycleListener();
        this.support.addListener(listener);
        this.support.fireLifecycleEvent("server", null);
        System.out.println("stop...");
    }

    public void fireLifecycleEvent(String type, Object data) {
        LifecycleEvent event = new LifecycleEvent(data, type);
        for (LifecycleListener LifecycleListener: lifecycleListeners) {
            LifecycleListener.lifecycleEvent(event);
        }
    }

}