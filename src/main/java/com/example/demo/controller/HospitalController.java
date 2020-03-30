package com.example.demo.controller;

import com.example.demo.dao.HospitalMapper;
import com.example.demo.dto.BaseResponse;
import com.example.demo.entity.Hospital;
import com.example.demo.enums.ResponseEnums;
import com.example.demo.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
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
@RequestMapping("/hospital")
public class HospitalController {

    private final HospitalService hospitalService;

    private final HospitalMapper hospitalMapper;

    public HospitalController(HospitalService hospitalService,HospitalMapper hospitalMapper) {
        this.hospitalService = hospitalService;
        this.hospitalMapper = hospitalMapper;
    }

    @RequestMapping(path = "/addOne",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public BaseResponse add(@RequestBody Hospital hospital) {
        BaseResponse baseResponse = new BaseResponse();
        try {
            hospitalService.addOne(hospital);
            baseResponse.setResultCode(ResponseEnums.Success.getCode());
            baseResponse.setResultMessage(ResponseEnums.Success.getDesc());
            baseResponse.setResultContent(hospital.getOid());
        } catch (Exception e) {
            baseResponse.setResultCode(ResponseEnums.Fail.getCode());
            baseResponse.setResultMessage(e.getCause()+e.getMessage());
        }
        return baseResponse;
    }

    @RequestMapping(path = "/findOne",method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public BaseResponse findOneByOid(@RequestParam("oid") Long oid){
        BaseResponse baseResponse = new BaseResponse();
        try {
            Hospital Hospital = hospitalService.findOneByOid(oid);
            baseResponse.setResultMessage(ResponseEnums.Success.getDesc());
            baseResponse.setResultCode(ResponseEnums.Success.getCode());
            baseResponse.setResultContent(Hospital);
        } catch (Exception e) {
            baseResponse.setResultCode(ResponseEnums.Fail.getCode());
            baseResponse.setResultMessage(e.getMessage());
        }
        return baseResponse;
    }

    @RequestMapping(path = "/findOne/{code}",method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public BaseResponse findOneByCode(@PathVariable("code") String code){
        BaseResponse baseResponse = new BaseResponse();
        try {
            Hospital Hospital = hospitalService.findOneByCode(code);
            baseResponse.setResultCode(ResponseEnums.Success.getCode());
            baseResponse.setResultMessage(ResponseEnums.Success.getDesc());
            baseResponse.setResultContent(Hospital);
        } catch (Exception e) {
            baseResponse.setResultCode(ResponseEnums.Fail.getCode());
            baseResponse.setResultCode(ResponseEnums.Success.getCode());
            baseResponse.setResultMessage(e.getMessage());
        }
        return baseResponse;
    }

    @RequestMapping(path = "/update",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public BaseResponse update(@RequestBody Hospital hospital) {
        BaseResponse baseResponse = new BaseResponse();
        try {
            hospitalService.update(hospital);
            baseResponse.setResultCode(ResponseEnums.Success.getCode());
            baseResponse.setResultMessage(ResponseEnums.Success.getDesc());
        } catch (Exception e) {
            baseResponse.setResultCode(ResponseEnums.Fail.getCode());
            baseResponse.setResultMessage(e.getCause()+e.getMessage());
        }
        return baseResponse;
    }


    @RequestMapping(path = "/findAll",method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public BaseResponse findAll(){
        BaseResponse baseResponse = new BaseResponse();
        try {
            List<Hospital> Hospital = hospitalService.findAll();
            baseResponse.setResultMessage(ResponseEnums.Success.getDesc());
            baseResponse.setResultCode(ResponseEnums.Success.getCode());
            baseResponse.setResultContent(Hospital);
        } catch (Exception e) {
            baseResponse.setResultCode(ResponseEnums.Fail.getCode());
            baseResponse.setResultMessage(e.getMessage());
        }
        return baseResponse;
    }


    @RequestMapping(path = "/addAndReturnId",method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    @Transactional
    public BaseResponse addAndReturnId(){
        BaseResponse baseResponse = new BaseResponse();
        try {
            Hospital hospital = new Hospital();
            hospital.setCreatedOn(new Date());
            hospital.setUpdatedOn(new Date());
            hospital.setCode("Test_2");
            hospital.setName("mybatis测试存储过程");
            hospital.setStatus("Active");
            hospitalMapper.addAndReturnId(hospital);
            baseResponse.setResultContent(hospital.getOid());
//            Map<String,Object> paramMap = new HashMap<>(5);
//            paramMap.put("result",null);
//            paramMap.put("createdOn",new Date());
//            paramMap.put("name","占位符方式测试存储过程");
//            paramMap.put("code","test");
//            paramMap.put("status","test");
//
//            hospitalMapper.addAndReturnId(paramMap);
//            baseResponse.setResultContent(paramMap.get("result"));

            baseResponse.setResultMessage(ResponseEnums.Success.getDesc());
            baseResponse.setResultCode(ResponseEnums.Success.getCode());
        } catch (Exception e) {
            baseResponse.setResultCode(ResponseEnums.Fail.getCode());
            baseResponse.setResultMessage(e.getMessage());
        }
        return baseResponse;
    }

}
