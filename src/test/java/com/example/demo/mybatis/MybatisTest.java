package com.example.demo.mybatis;

import com.example.demo.dao.HospitalMapper;
import com.example.demo.entity.Hospital;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.util.List;

/**
 * Author:Created by wx on 2020/1/6
 * Desc:
 */
public class MybatisTest {



    public static void main(String[] args) throws IOException {
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(Resources.getResourceAsStream("mybatis/config/mybatis-config_3.xml"));
        SqlSession sqlSession = sqlSessionFactory.openSession();
        HospitalMapper mapper = sqlSession.getMapper(HospitalMapper.class);
        List<Hospital> all = mapper.findAll();
        System.out.println(all);
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.setDateFormat("yyyy-MM-dd HH:mm:ss").setPrettyPrinting().create();


        System.out.println(gson.toJson(all));
        Hospital oneByOid = mapper.findOneByOid(1L);

        Hospital public_2_people = mapper.findOneByCode("Public_2_people");
    }
}
