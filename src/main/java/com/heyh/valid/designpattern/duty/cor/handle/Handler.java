package com.heyh.valid.designpattern.duty.cor.handle;

import com.heyh.valid.designpattern.duty.cor.requester.ErrorRequester;

/**
 * 抽象处理者，定义一个处理请求的接口
 */
public abstract class Handler {

    // 记录当前责任链的下一个环节
    private Handler nextHandler;
    // 标记当前子类的类型
    private String duty;
    public static final String DBA = "SQL and the database";
    public static final String FRONT = "HTML and CSS";
    public static final String BGD = "Java and XML";

    // 方便子类设置自己的类型（子类通过无参数的构造器隐藏该实现）
    public Handler(String duty) {
        this.duty = duty;
    }

    // 责任链的指责传递逻辑的实现，不支持子类的覆盖
    public final void handlerMessage(ErrorRequester requester) {
        if (requester.getDuty().equals(duty)) {
            response(requester);
        } else {
            if (nextHandler != null) {
                nextHandler.handlerMessage(requester);
            } else {
                System.out.println("The Error is due to others!!!");
            }
        }
    }

    // 找到合适的类型时，回应请求的函数
    protected  abstract void response(ErrorRequester requester);

    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

}