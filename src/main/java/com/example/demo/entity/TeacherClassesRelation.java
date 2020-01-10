package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * Author:Created by wx on 2020/1/10
 * Desc:
 */
@Data
public class TeacherClassesRelation {
    private Long id;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createdOn;// 创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updatedOn;// 更新时间
    private Long teacherId;// 教师id
    private Long classesId;// 班级id
    private String status;// 状态
}
