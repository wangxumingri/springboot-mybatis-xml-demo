package com.example.demo.service.impl;

import com.example.demo.config.DataSource;
import com.example.demo.dao.CouponTemplateMapper;
import com.example.demo.dao2.CouponTemplateMapper2;
import com.example.demo.entity.CouponTemplate;
import com.example.demo.service.CouponTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CouponTemplateServiceImpl implements CouponTemplateService {

    @Autowired
    private CouponTemplateMapper couponTemplateMapper;


//    @DataSource(name = "new")
    @DataSource(name = "old")
    @Override
    public Long insert(CouponTemplate couponTemplate) {
        int effectRows = couponTemplateMapper.insert(couponTemplate);
        return effectRows > 0 ? couponTemplate.getId():null;
    }
    @DataSource(name = "new")
    @Override
    public int updateByPrimaryKey(CouponTemplate couponTemplate) {
        return couponTemplateMapper.updateByPrimaryKey(couponTemplate);
    }
    @Override
    public CouponTemplate selectByPrimaryKey(Long id) {
        return couponTemplateMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<CouponTemplate> selectAll() {
        return couponTemplateMapper.selectAll();
    }
}
