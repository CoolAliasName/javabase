package com.heyh.valid.enums;

public enum  ProcessStatusCode {

    CHECK_APPOINTMENT("预约中(待预约)", (short)1),
    CHECK_PENDING_FEEDBACK("待反馈", (short)2),
    CHECK_FEEDBACK("已反馈(待受理)", (short)3),
    CHECK_ADMISSIBLE("已受理(待检定)", (short)4),
    CHECK_ALREADY_CHECKED("已检定(检定完成)", (short)5),
    CHECK_RESERVATION_FAILURE("预约失败", (short)6);

    private Short code;     // 代码
    private String name;    // 名称

    private ProcessStatusCode(String name, Short code) {
        this.name = name;
        this.code = code;
    }

}
