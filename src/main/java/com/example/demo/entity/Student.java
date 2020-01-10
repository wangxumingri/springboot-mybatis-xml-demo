package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * Author:Created by wx on 2020/1/10
 * Desc:
 */
@Data
public class Student {
    private Long id;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createdOn;// 创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updatedOn;// 更新时间
    private String name;// 姓名
    private String number;// 学号
    private String gender;// 性别
    private Integer age;// 年龄
    private Long classesId;// 所属班级
}
