package com.heyh.valid.designpattern.observer;

import com.heyh.valid.designpattern.observer.lifecycle.Lifecycle;
import com.heyh.valid.designpattern.observer.lifecycle.impl.StandarServer;

public class Observer {

    public static void main(String[] args) {
        Lifecycle lifecycle = new StandarServer();

        lifecycle.start();
        lifecycle.stop();
    }

}