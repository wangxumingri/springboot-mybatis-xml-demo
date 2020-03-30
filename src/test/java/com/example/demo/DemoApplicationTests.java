package com.example.demo;

import com.example.demo.dao.HospitalMapper;
import com.example.demo.dao.UserMapper;
import com.example.demo.entity.Hospital;
import com.example.demo.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;

@SpringBootTest
@RunWith(SpringRunner.class)
class DemoApplicationTests {

    @Resource
    private UserMapper userMapper;

    @Resource
    private HospitalMapper hospitalMapper;
    @Test
    public void testSave(){
        User user = new User();
        user.setName("测试人员1");
        user.setAge(12);
        user.setBirthDay(new Date());

        userMapper.save(user);
    }

    @Test
    public void testProcedure(){

    }


}
