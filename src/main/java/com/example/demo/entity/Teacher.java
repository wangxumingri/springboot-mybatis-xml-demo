package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * Author:Created by wx on 2020/1/10
 * Desc:
 */
@Data
public class Teacher {
    private Long id;
    private Long schoolId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createdOn;// 创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updatedOn;// 更新时间
    private String name;// 姓名
    private String type;// 学科类型
    private Integer headmaster;// 是否班主任:1是 0否
    private String number;// 工号
}
