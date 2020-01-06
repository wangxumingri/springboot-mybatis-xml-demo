package com.example.demo.controller;

import com.example.demo.dto.BaseResponse;
import com.example.demo.entity.Hospital;
import com.example.demo.enums.ResponseEnums;
import com.example.demo.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Author:Created by wx on 2019/12/20
 * Desc:
 */
@Controller
@RequestMapping("/hospital")
public class HospitalController {

    @Autowired
    private HospitalService hospitalService;

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

}
