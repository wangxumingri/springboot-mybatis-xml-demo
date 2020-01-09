package com.example.demo.controller;

import com.example.demo.dao.UserMapper;
import com.example.demo.dto.BaseResponse;
import com.example.demo.entity.Hospital;
import com.example.demo.entity.User;
import com.example.demo.entity.query.PageParam;
import com.example.demo.entity.query.UserQueryParam;
import com.example.demo.enums.ResponseEnums;
import com.example.demo.service.HospitalService;
import com.example.demo.utils.ResponseUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author:Created by wx on 2019/12/20
 * Desc:
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserMapper userMapper;

    @RequestMapping(path = "/addOne", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public BaseResponse addUser(@RequestBody User user) {
        BaseResponse baseResponse = new BaseResponse();
        try {
            Long oid = userMapper.save(user);
            baseResponse = ResponseUtil.responseSuccess(user.getOid());
        } catch (Exception e) {
            baseResponse = ResponseUtil.responseErrot(e.getMessage());
        }
        return baseResponse;
    }

    @RequestMapping(path = "/findOne", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public BaseResponse findOne(@RequestParam("oid") String oid) {
        BaseResponse baseResponse = new BaseResponse();
        try {
            User user = userMapper.selectById(oid);
            baseResponse = ResponseUtil.responseSuccess(user);
        } catch (Exception e) {
            baseResponse = ResponseUtil.responseErrot(e.getMessage());
        }
        return baseResponse;
    }


    @RequestMapping(path = "/findByParamAnnotation", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public BaseResponse findByParamAnnotation(@RequestParam("hospitalCode") String hospitalCode) {
        BaseResponse baseResponse = new BaseResponse();
        try {
            List<User> userList = userMapper.findByParamAnnotation(hospitalCode);
            baseResponse = ResponseUtil.responseSuccess(userList);
        } catch (Exception e) {
            baseResponse = ResponseUtil.responseErrot(e.getMessage());
        }
        return baseResponse;
    }


    @RequestMapping(path = "/findByPojo", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public BaseResponse findByPojo(@RequestBody UserQueryParam userQueryParam) {
        BaseResponse baseResponse = new BaseResponse();
        try {
            List<User> userList = userMapper.findByPojo(userQueryParam);
            baseResponse = ResponseUtil.responseSuccess(userList);
        } catch (Exception e) {
            baseResponse = ResponseUtil.responseErrot(e.getMessage());
        }
        return baseResponse;
    }

    @RequestMapping(path = "/findByMap", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public BaseResponse findByMap(@RequestParam("hospitalCode") String hopsitalCode) {
        BaseResponse baseResponse = new BaseResponse();
        try {
            Map<String, Object> queryMap = new HashMap<>(1);
            queryMap.put("hospitalCode", hopsitalCode);
            List<User> userList = userMapper.findByMap(queryMap);
            baseResponse = ResponseUtil.responseSuccess(userList);
        } catch (Exception e) {
            baseResponse = ResponseUtil.responseErrot(e.getMessage());
        }
        return baseResponse;
    }

    @RequestMapping(path = "/findByMix", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public BaseResponse findByMix(@RequestParam("hospitalCode") String hospitalCode, @RequestParam(defaultValue = "1") String start, @RequestParam(defaultValue = "3") String limit) {
        BaseResponse baseResponse = new BaseResponse();
        try {
            UserQueryParam userQueryParam = new UserQueryParam();
            userQueryParam.setHospitalCode(hospitalCode);
            PageParam pageParam = new PageParam();
            pageParam.setStart(Integer.parseInt(start));
            pageParam.setLimit(Integer.parseInt(limit));
            List<User> userList = userMapper.findByMix(userQueryParam, pageParam);
            baseResponse = ResponseUtil.responseSuccess(userList);
        } catch (Exception e) {
            baseResponse = ResponseUtil.responseErrot(e.getMessage());
        }
        return baseResponse;
    }

    @RequestMapping(path = "/findByPageWithRowBounds", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public BaseResponse findByPageWithRowBounds(@RequestParam("hospitalCode") String hopsitalCode) {
        BaseResponse baseResponse = new BaseResponse();
        try {
            RowBounds rowBounds = new RowBounds(2,3);
            List<User> userList = userMapper.findByPageWithRowBounds(hopsitalCode,rowBounds);
            baseResponse = ResponseUtil.responseSuccess(userList);
        } catch (Exception e) {
            baseResponse = ResponseUtil.responseErrot(e.getMessage());
        }
        return baseResponse;
    }
}
