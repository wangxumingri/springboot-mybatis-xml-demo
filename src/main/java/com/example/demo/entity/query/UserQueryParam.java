package com.example.demo.entity.query;

import lombok.Data;

/**
 * Author:Created by wx on 2020/1/9
 * Desc:
 */
@Data
public class UserQueryParam {
    private Long oid ;
    private String hospitalCode;// 医院code
    private String name;// 姓名
    private String mobile;// 手机
}
