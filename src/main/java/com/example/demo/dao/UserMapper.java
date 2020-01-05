package com.example.demo.dao;

import com.example.demo.entity.User;

import java.util.List;

/**
 * Author:Created by wx on 2019/12/31
 * Desc:
 */
public interface UserMapper {
    /**
     * 新增用户
     *
     * @param user
     * @return
     */
    Long save(User user);

    /**
     * 更新用户信息
     *
     * @param user
     * @return
     */
//    int update(User user);

    /**
     * 根据id删除
     *
     * @param id
     * @return
     */
    int deleteById(int id);

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    User selectById(String id);

    /**
     * 查询所有用户信息
     *
     * @return
     */
    List<User> selectAll();
}
