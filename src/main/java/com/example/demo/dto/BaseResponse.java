package com.example.demo.dto;

import lombok.Data;

/**
 * Author:Created by wx on 2019/12/21
 * Desc:
 */
@Data
public class BaseResponse {
    private String resultCode;
    private String resultMessage;
    private Object resultContent;
}
