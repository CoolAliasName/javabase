package com.heyh.valid.designpattern.duty.cor.handle.impl;

import com.heyh.valid.designpattern.duty.cor.requester.ErrorRequester;
import com.heyh.valid.designpattern.duty.cor.handle.Handler;

public class FRONTHandler extends Handler {

    //设置当前子类的处理器类型
    public FRONTHandler() {
        super(Handler.FRONT);
    }

    //如果当前类型匹配上，那么进行响应
    @Override
    protected void response(ErrorRequester requester) {
        System.out.println("What horrible " + requester.getDuty() + " is!!!");
    }
}
