package com.example.demo.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;


@Configuration
@Component
public class DynamicDataSourceConfig {
    @Bean(name = "newDataSourceProperties")
    @ConfigurationProperties(prefix = "spring.datasource.new")
    public DataSourceProperties newDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    public javax.sql.DataSource newDataSource(@Qualifier("newDataSourceProperties") DataSourceProperties dataSourceProperties) {
//        return DruidDataSourceBuilder.create().build();
        return dataSourceProperties.initializeDataSourceBuilder().build();
    }

    @Bean(name = "oldDataSourceProperties")
    @ConfigurationProperties(prefix = "spring.datasource.old")
    public DataSourceProperties oldDataSourceProperties() {
        return new DataSourceProperties();
    }


    @Bean
    public DataSource oldDataSource(@Qualifier("oldDataSourceProperties") DataSourceProperties dataSourceProperties) {
//        return DruidDataSourceBuilder.create().build();
        return dataSourceProperties.initializeDataSourceBuilder().build();
    }

    @Bean
    @Primary
    public DynamicDataSource dataSource(DataSource oldDataSource, DataSource newDataSource) {
        Map<Object, Object> targetDataSources = new HashMap<>();
        targetDataSources.put("old", oldDataSource);
        targetDataSources.put("new", newDataSource);
        return new DynamicDataSource(oldDataSource, targetDataSources);
    }
}