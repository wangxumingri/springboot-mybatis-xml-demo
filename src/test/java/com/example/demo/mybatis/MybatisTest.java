package com.example.demo.mybatis;

import com.example.demo.dao.HospitalMapper;
import com.example.demo.entity.Hospital;
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
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(Resources.getResourceAsStream("mybatis/config/mybatis-config_2.xml"));
        SqlSession sqlSession = sqlSessionFactory.openSession();
        HospitalMapper mapper = sqlSession.getMapper(HospitalMapper.class);
        List<Hospital> all = mapper.findAll();
        System.out.println(all);
    }
}
