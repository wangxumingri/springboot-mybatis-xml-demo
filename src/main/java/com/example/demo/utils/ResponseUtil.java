package com.example.demo.utils;

import com.example.demo.dto.BaseResponse;
import com.example.demo.enums.ResponseEnums;

/**
 * Author:Created by wx on 2020/1/9
 * Desc:
 */
public class ResponseUtil {
    public static BaseResponse responseSuccess(Object content){
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setResultMessage(ResponseEnums.Success.getDesc());
        baseResponse.setResultCode(ResponseEnums.Success.getCode());
        baseResponse.setResultContent(content);
        return baseResponse;
    }
    public static BaseResponse responseSuccess(){
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setResultMessage(ResponseEnums.Success.getDesc());
        baseResponse.setResultCode(ResponseEnums.Success.getCode());
        return baseResponse;
    }

    public static BaseResponse responseErrot(Object errMsg){
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setResultMessage(ResponseEnums.Fail.getDesc());
        baseResponse.setResultCode(ResponseEnums.Fail.getCode());
        baseResponse.setResultContent(errMsg);
        return baseResponse;
    }


}
