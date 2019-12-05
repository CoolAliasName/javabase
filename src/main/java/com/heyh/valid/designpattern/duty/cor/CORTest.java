package com.heyh.valid.designpattern.duty.cor;

import com.heyh.valid.designpattern.duty.cor.handle.Handler;
import com.heyh.valid.designpattern.duty.cor.handle.impl.BGDHandler;
import com.heyh.valid.designpattern.duty.cor.handle.impl.DBAHandler;
import com.heyh.valid.designpattern.duty.cor.handle.impl.FRONTHandler;
import com.heyh.valid.designpattern.duty.cor.requester.ErrorRequester;

import java.util.HashMap;
import java.util.Map;

public class CORTest {
    public static void main(String[] args) {
        // 构造词典
        Map<Integer, String> map = new HashMap<>();
        map.put(0, Handler.DBA);
        map.put(1, Handler.BGD);
        map.put(2, Handler.FRONT);
        int times = 0;

        // 建立责任链
        Handler dba = new DBAHandler();
        Handler bgd = new BGDHandler();
        Handler front = new FRONTHandler();
        dba.setNextHandler(bgd);
        bgd.setNextHandler(front);

        // 生成随机的请求，并且响应
        while (times++ != 10) {
            ErrorRequester requester = new ErrorRequester();
            requester.setDuty(map.get((int)(Math.random()*100)%3) );
            dba.handlerMessage(requester);
        }
    }
}