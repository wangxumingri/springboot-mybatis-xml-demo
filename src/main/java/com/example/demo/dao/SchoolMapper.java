package com.example.demo.dao;

import com.example.demo.entity.School;

import java.util.List;

/**
 * Author:Created by wx on 2020/1/10
 * Desc:
 */
public interface SchoolMapper {

    /**
     * 增加
     * @param school
     */
    void save(School school);

    /**
     * 根据主键删除
     * @param id
     */
    void deleteById(Long id);

    /**
     * 更新
     * @param school
     */
    void update(School school);

    /**
     * 根据主键查询
     * @param id
     * @return
     */
    School findOneById(Long id);

    /**
     * 查询所有
     * @return
     */
    List<School> findAll();

    /**
     * 根据code查询
     * @param code
     * @return
     */
    School findOneByCode(String code);

    /**
     * 根据code和status查询
     * @param code
     * @param status
     * @return
     */
    School findOneByCodeAndStatus(String code,String status);
}
