package com.heyh.valid.designpattern.observer.util;

import java.io.Serializable;

/**
 * 辅助类扩展了观察者的功能
 */
public class LifecycleEvent implements Serializable {

    private Object data;
    private String type;

    public LifecycleEvent(Object data, String type) {
        this.data = data;
        this.type = type;
    }

    public Object getData() {
        return data;
    }

    public String getType() {
        return type;
    }

}
