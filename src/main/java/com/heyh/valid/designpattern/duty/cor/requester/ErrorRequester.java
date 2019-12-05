package com.heyh.valid.designpattern.duty.cor.requester;

/**
 * 发出请求等待处理的类，它无需关注到底是哪个具体的Handler处理它的请求
 */
public class ErrorRequester {

    //标记请求的类型
    private String duty;

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty;
    }

}
