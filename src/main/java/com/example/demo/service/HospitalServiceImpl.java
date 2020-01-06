package com.example.demo.service;

import com.example.demo.dao.HospitalMapper;
import com.example.demo.entity.Hospital;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
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
        if (hospital == null){
            throw new RuntimeException("参数非法");
        }
        if (hospital.getOid() == null){
            throw new RuntimeException("参数非法");
        }
        Hospital hospitalMapperOneByOid = hospitalMapper.findOneByOid(hospital.getOid());
        if (hospitalMapperOneByOid == null){
            throw new RuntimeException("修改对象不存在");
        }
        if (hospital.getUpdatedOn() == null){
            hospital.setUpdatedOn(new Date());
        }
        hospitalMapper.update(hospital);
    }

    @Override
    public Hospital findOneByOid(Long oid) {
        return hospitalMapper.findOneByOid(oid);
    }

    @Override
    public List<Hospital> findAll() {
        return hospitalMapper.findAll();
    }

    @Override
    public Hospital findOneByCode(String code) {
        return hospitalMapper.findOneByCode(code);
    }


}
