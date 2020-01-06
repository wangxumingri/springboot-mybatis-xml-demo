package com.example.demo.controller;

import com.example.demo.dao.UserMapper;
import com.example.demo.dto.BaseResponse;
import com.example.demo.entity.Hospital;
import com.example.demo.entity.User;
import com.example.demo.enums.ResponseEnums;
import com.example.demo.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Author:Created by wx on 2019/12/20
 * Desc:
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ApplicationContext applicationContext;


    @RequestMapping(path = "/addOne",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public BaseResponse addUser(@RequestBody User user) {
        BaseResponse baseResponse = new BaseResponse();
        try {
            Long oid = userMapper.save(user);
            System.out.println(oid);
            System.out.println(user.getOid());// 获取主键
            baseResponse.setResultCode(ResponseEnums.Success.getCode());
            baseResponse.setResultMessage(ResponseEnums.Success.getDesc());
            baseResponse.setResultContent(user.getOid());
        } catch (Exception e) {
            baseResponse.setResultCode(ResponseEnums.Fail.getCode());
            baseResponse.setResultMessage(e.getCause()+e.getMessage());
        }
        return baseResponse;
    }

    @RequestMapping(path = "/findOne",method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public BaseResponse findOne(@RequestParam("oid") String oid){
        BaseResponse baseResponse = new BaseResponse();
        try {
            User user = userMapper.selectById(oid);
            baseResponse.setResultMessage(ResponseEnums.Success.getDesc());
            baseResponse.setResultCode(ResponseEnums.Success.getCode());
            baseResponse.setResultContent(user);
        } catch (Exception e) {
            baseResponse.setResultCode(ResponseEnums.Fail.getCode());
            baseResponse.setResultMessage(e.getMessage());
        }
        return baseResponse;
    }

}
