package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * Author:Created by wx on 2020/1/10
 * Desc:
 */
@Data
public class School {
    private Long id;// 主键
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createdOn;// 创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updatedOn;// 更新时间
    private String name;// 名称
    private String code;// 编码
    private String status;// 状态

    List<Teacher> teacherList;// 1对多
}
