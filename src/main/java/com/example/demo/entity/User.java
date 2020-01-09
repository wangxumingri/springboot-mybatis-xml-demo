package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * Author:Created by wx on 2019/12/31
 * Desc:
 */
@Data
public class User {
    private Long oid;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createdOn;// 创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updatedOn;// 更新时间
    private String openId;// 微信openId
    private String hospitalCode;// 医院code
    private String name; //姓名
    private String gender; // 性别，1男0女
    private Integer age;
    private String cardNumber; //证件号
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date birthDay; // 生日
    private String mobile;
}
