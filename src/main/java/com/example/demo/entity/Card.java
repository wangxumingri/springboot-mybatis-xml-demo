package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * Author:Created by wx on 2020/1/10
 * Desc:
 */
@Data
public class Card {
    private Long id;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createdOn;// 创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updatedOn;// 更新时间
    private String number;// 学号/工号
    private String type;// 教职工/学生
    private String status;// 状态
}
