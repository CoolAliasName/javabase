package com.heyh.valid.designpattern.observer.listener;

import com.heyh.valid.designpattern.observer.util.LifecycleEvent;

/**
 * 抽象观察者
 * 定义一个 lifecycleEvent 方法，这个方法就是当主题变化时要执行的方法
 */
public interface LifecycleListener {

    public void lifecycleEvent(LifecycleEvent event);

}
