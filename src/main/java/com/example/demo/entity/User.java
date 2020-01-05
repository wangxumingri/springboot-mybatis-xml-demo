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
    private String name; //姓名
    private String gender; // 性别，1男0女
    private Integer age;
    private String cardNumber; //证件号
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date birthDay; // 生日
    private String mobile;
}
