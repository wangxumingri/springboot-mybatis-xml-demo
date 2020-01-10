package com.example.demo.controller;

import com.example.demo.dao.SchoolMapper;
import com.example.demo.dto.BaseResponse;
import com.example.demo.entity.School;
import com.example.demo.entity.query.PageParam;
import com.example.demo.entity.query.UserQueryParam;
import com.example.demo.utils.ResponseUtil;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author:Created by wx on 2019/12/20
 * Desc:
 */
@Controller
@RequestMapping("/school")
public class SchoolController {

    @Resource
    private SchoolMapper schoolMapper;

    @RequestMapping(path = "/save", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public BaseResponse save(@RequestBody School school) {
        BaseResponse baseResponse = new BaseResponse();
        try {
            schoolMapper.save(school);
            baseResponse = ResponseUtil.responseSuccess(school.getId());
        } catch (Exception e) {
            baseResponse = ResponseUtil.responseErrot(e.getMessage());
        }
        return baseResponse;
    }



    @RequestMapping(path = "/deleteById/{id}", method = RequestMethod.DELETE, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public BaseResponse deleteById(@PathVariable("id") Long id) {
        BaseResponse baseResponse = new BaseResponse();
        try {
            School school = schoolMapper.findOneById(id);
            if (null == school){
                throw new RuntimeException("删除失败:学校不存在");
            }
            schoolMapper.deleteById(id);
            baseResponse = ResponseUtil.responseSuccess();
        } catch (Exception e) {
            baseResponse = ResponseUtil.responseErrot(e.getMessage());
        }
        return baseResponse;
    }

    @RequestMapping(path = "/update", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public BaseResponse update(@RequestBody School school) {
        BaseResponse baseResponse = new BaseResponse();
        try {
            School schoolFromDB = schoolMapper.findOneById(school.getId());
            if (null == schoolFromDB){
                throw new RuntimeException("修改失败:学校不存在");
            }
            schoolMapper.update(school);
            baseResponse = ResponseUtil.responseSuccess();
        } catch (Exception e) {
            baseResponse = ResponseUtil.responseErrot(e.getMessage());
        }
        return baseResponse;
    }



    @RequestMapping(path = "/findOne/{id}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public BaseResponse findOneById(@PathVariable("id") Long id) {
        BaseResponse baseResponse = new BaseResponse();
        try {
            School school = schoolMapper.findOneById(id);
            baseResponse = ResponseUtil.responseSuccess(school);
        } catch (Exception e) {
            baseResponse = ResponseUtil.responseErrot(e.getMessage());
        }
        return baseResponse;
    }


    @RequestMapping(path = "/findOneByCode/{code}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public BaseResponse findOneByCode(@PathVariable("code") String code) {
        BaseResponse baseResponse = new BaseResponse();
        try {
            School school = schoolMapper.findOneByCode(code);
            baseResponse = ResponseUtil.responseSuccess(school);
        } catch (Exception e) {
            baseResponse = ResponseUtil.responseErrot(e.getMessage());
        }
        return baseResponse;
    }


    @RequestMapping(path = "/findOneByCodeAndStatus", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public BaseResponse findOneByCodeAndStatus(@RequestParam String code,@RequestParam String status) {
        BaseResponse baseResponse = new BaseResponse();
        try {
            School school = schoolMapper.findOneByCodeAndStatus(code,status);
            baseResponse = ResponseUtil.responseSuccess(school);
        } catch (Exception e) {
            baseResponse = ResponseUtil.responseErrot(e.getMessage());
        }
        return baseResponse;
    }

    @RequestMapping(path = "/findAll", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public BaseResponse findAll() {
        BaseResponse baseResponse = new BaseResponse();
        try {
            List<School> schools = schoolMapper.findAll();
            baseResponse = ResponseUtil.responseSuccess(schools);
        } catch (Exception e) {
            baseResponse = ResponseUtil.responseErrot(e.getMessage());
        }
        return baseResponse;
    }


}
