package com.example.demo.service;

import com.example.demo.entity.CouponTemplate;

import java.util.List;

public interface CouponTemplateService {
    /**
     * 新增券模版
     * @param couponTemplate
     * @return
     */
    Long insert(CouponTemplate couponTemplate);

    /**
     * 更新券模版
     * @param couponTemplate
     * @return
     */
    int updateByPrimaryKey(CouponTemplate couponTemplate);

    /**
     * 根据主键查询券模版
     * @param id
     * @return
     */
    CouponTemplate selectByPrimaryKey(Long id);

    /**
     * 根据主键查询券模版
     * @param
     * @return
     */
    List<CouponTemplate> selectAll();
}
