package com.example.demo.type;

import org.apache.ibatis.type.*;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Author:Created by wx on 2020/1/7
 * Desc:
 */

@MappedTypes(String.class)
@MappedJdbcTypes(JdbcType.VARCHAR)
public class MyTypeHandler implements TypeHandler<String> {
    @Override
    public void setParameter(PreparedStatement ps, int i, String parameter, JdbcType jdbcType) throws SQLException {
        System.out.println("com.example.demo.type.MyTypeHandler.setParameter");
        ps.setString(i, parameter);
    }

    @Override
    public String getResult(ResultSet rs, String columnName) throws SQLException {
        System.out.println("com.example.demo.type.MyTypeHandler.getNullableResult(java.sql.ResultSet, java.lang.String)");

        return rs.getString(columnName);
    }

    @Override
    public String getResult(ResultSet rs, int columnIndex) throws SQLException {
        System.out.println("com.example.demo.type.MyTypeHandler.getNullableResult(java.sql.CallableStatement, int)");
        return rs.getString(columnIndex);    }

    @Override
    public String getResult(CallableStatement cs, int columnIndex) throws SQLException {
        System.out.println("com.example.demo.type.MyTypeHandler.getNullableResult(java.sql.CallableStatement, int)");
        return cs.getString(columnIndex);    }
}
