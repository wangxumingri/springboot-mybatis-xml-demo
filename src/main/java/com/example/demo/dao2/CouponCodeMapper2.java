package com.example.demo.dao2;

import com.example.demo.entity.CouponCode;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CouponCodeMapper2 {
    int deleteByPrimaryKey(Long id);

    int insert(CouponCode record);

    int insertSelective(CouponCode record);

    CouponCode selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CouponCode record);

    int updateByPrimaryKey(CouponCode record);
}