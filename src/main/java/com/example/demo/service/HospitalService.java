package com.example.demo.service;

import com.example.demo.entity.Hospital;

import java.util.List;

/**
 * Author:Created by wx on 2019/12/20
 * Desc:
 */
public interface HospitalService {
    Long addOne(Hospital hospital);

    void update(Hospital hospital);

    Hospital findOneByOid(Long oid);

    Hospital findOneByCode(String code);

    Long getOid(String code);
}
