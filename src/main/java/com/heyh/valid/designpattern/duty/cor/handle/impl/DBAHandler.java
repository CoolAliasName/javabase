package com.heyh.valid.designpattern.duty.cor.handle.impl;

import com.heyh.valid.designpattern.duty.cor.requester.ErrorRequester;
import com.heyh.valid.designpattern.duty.cor.handle.Handler;

public class DBAHandler extends Handler {

    // 设置当前子类的处理器类型
    public DBAHandler() {
        super(Handler.DBA);
    }

    @Override
    protected void response(ErrorRequester requester) {
        System.out.println( "What horrible "+ requester.getDuty() + " is!!!!");
    }
}
