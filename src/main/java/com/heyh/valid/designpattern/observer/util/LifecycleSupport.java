package com.heyh.valid.designpattern.observer.util;

import com.heyh.valid.designpattern.observer.listener.LifecycleListener;

import java.util.ArrayList;
import java.util.List;

public class LifecycleSupport {

    List<LifecycleListener> list = new ArrayList();

    public void addListener(LifecycleListener listener) {
        list.add(listener);
    }

    public void fireLifecycleEvent(String type, Object data) {
        LifecycleEvent event = new LifecycleEvent(data, type);
        for (LifecycleListener listener: list) {
            listener.lifecycleEvent(event);
        }
    }

}
