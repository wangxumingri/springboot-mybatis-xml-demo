package com.example.demo.controller;

import com.example.demo.dto.BaseResponse;
import com.example.demo.entity.CouponTemplate;
import com.example.demo.service.CouponTemplateService;
import com.example.demo.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coupon/template")
public class CouponTemplateController {

    @Autowired
    private CouponTemplateService couponTemplateService;

    @PostMapping("/add")
    public BaseResponse addCouponTemplate(@RequestBody CouponTemplate couponTemplate){
        Long couponTemplateId = couponTemplateService.insert(couponTemplate);
        return ResponseUtil.responseSuccess(couponTemplateId);
    }


    @GetMapping("/list")
    public BaseResponse list(){
        List<CouponTemplate> couponTemplates = couponTemplateService.selectAll();
        return ResponseUtil.responseSuccess(couponTemplates);
    }
}

