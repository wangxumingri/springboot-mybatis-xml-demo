package com.example.demo.dao;

import com.example.demo.entity.User;
import com.example.demo.entity.query.PageParam;
import com.example.demo.entity.query.UserQueryParam;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
import java.util.Map;

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

    /**
     * 使用Map传递多个查询参数
     * @param parameters
     * @return
     */
    List<User> findByMap(Map<String,Object> parameters);

    /**
     * 使用@Param注解传递查询参数
     * @param hospitalCode
     * @return
     */
    List<User> findByParamAnnotation(@Param("hospital") String hospitalCode);

    /**
     * 使用JavaBean传递查询参数
     * @param userQueryParam
     * @return
     */
    List<User> findByPojo(UserQueryParam userQueryParam);

    /**
     * 混用注解和JavaBean传递查询参数
     * @param userQueryParam
     * @param pageParam
     * @return
     */
    List<User> findByMix(@Param(("user")) UserQueryParam userQueryParam, @Param("page") PageParam pageParam);

    /**
     * 使用mybatis的 RowBounds 实现分页查询
     * @param hospitalCode
     * @param rowBounds
     * @return
     */
    List<User> findByPageWithRowBounds(String hospitalCode, RowBounds rowBounds);

}
