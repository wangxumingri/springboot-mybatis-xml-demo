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
//@Mapper
public interface HospitalMapper {
//    @Insert("INSERT INTO bl_hospital ()")
    Long addOne(Hospital hospital);

    void update(Hospital hospital);

    Hospital findOneByOid(Long oid);

//    @Select("SELECT * FROM bl_hospital WHERE code=#{code}")
    Hospital findOneByCode(@Param("code") String code);

    Long getOid(String code);
}
