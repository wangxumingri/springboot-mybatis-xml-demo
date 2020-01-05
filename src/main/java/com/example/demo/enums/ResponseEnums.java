package com.example.demo.enums;

/**
 * Author:Created by wx on 2019/12/31
 * Desc:
 */
public enum ResponseEnums {
    Success("success","处理成功"),
    Fail("fail","处理识别");

    private String code;
    private String desc;


    ResponseEnums(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
