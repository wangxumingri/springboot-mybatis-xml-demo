package com.example.demo.dao;

import com.example.demo.entity.Teacher;

import java.util.List;

/**
 * Author:Created by wx on 2020/1/10
 * Desc:
 */
public interface TeacherMapper {

    /**
     * 增加
     * @param school
     */
    void save(Teacher school);

    /**
     * 根据主键删除
     * @param id
     */
    void deleteById(Long id);

    /**
     * 更新
     * @param school
     */
    void update(Teacher school);

    /**
     * 根据主键查询
     * @param id
     * @return
     */
    Teacher findOneById(Long id);

    /**
     * 查询所有
     * @return
     */
    List<Teacher> findAll();

    /**
     * 根据code查询
     * @param schoolId
     * @param number
     * @return
     */
    Teacher findOneBySchoolIdAndNumber(Long schoolId,String number);


    /**
     * 查询学校下所有老师
     * @param schoolId
     * @return
     */
    List<Teacher> findAllBySchoolId(Long schoolId);
}
