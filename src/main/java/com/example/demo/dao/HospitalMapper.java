package com.example.demo.dao;

import com.example.demo.entity.Hospital;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Author:Created by wx on 2019/12/31
 * Desc:
 */
public interface HospitalMapper {
    Long addOne(Hospital hospital);

    void update(Hospital hospital);

    Hospital findOneByOid(Long oid);

    Hospital findOneByCode(String code);

    List<Hospital> findAll();

    void delete(Long oid);
//    Long getOid(String code);
}
