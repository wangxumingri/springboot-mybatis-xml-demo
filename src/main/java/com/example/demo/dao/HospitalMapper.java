package com.example.demo.dao;

import com.example.demo.entity.Hospital;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.StatementType;

import java.util.List;
import java.util.Map;

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
//
    @Insert(value = "call addAndReturnId(" +
            "#{oid,mode=OUT,jdbcType=BIGINT}," +
            "#{createdOn,mode=IN}," +
            "#{name,mode=IN}," +
            "#{code,mode=IN}," +
            "#{status,mode=IN}" +
            ")")
    @Options(statementType = StatementType.CALLABLE )
    void addAndReturnId(Hospital hospital);
    /**
     * 存储过程测试：parameterMap方式
     */
//    void addAndReturnId(Map<String,Object> paramMap);
}
