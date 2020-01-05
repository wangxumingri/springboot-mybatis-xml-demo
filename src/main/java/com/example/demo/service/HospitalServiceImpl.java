package com.example.demo.service;

import com.example.demo.dao.HospitalMapper;
import com.example.demo.entity.Hospital;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Author:Created by wx on 2019/12/20
 * Desc:
 */
@Service
public class HospitalServiceImpl implements HospitalService {
    @Resource
    private HospitalMapper hospitalMapper;

    @Override
    public Long addOne(Hospital hospital) {
        Long oid = null;
        if (hospital != null){
            Hospital hospitalInDB = hospitalMapper.findOneByCode(hospital.getCode());
            if (hospitalInDB != null){
                throw new RuntimeException(hospitalInDB.getName()+"已存在");
            }else {
                oid = hospitalMapper.addOne(hospital);
            }
        }
        return oid;

    }

    @Override
    public void update(Hospital hospital) {
        hospitalMapper.update(hospital);
    }

    @Override
    public Hospital findOneByOid(Long oid) {
        return hospitalMapper.findOneByOid(oid);
    }

    @Override
    public Hospital findOneByCode(String code) {
        return hospitalMapper.findOneByCode(code);
    }

    @Override
    public Long getOid(String code) {
        return hospitalMapper.getOid(code);
    }
}
