//package com.example.demo.config;
//
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.mybatis.spring.annotation.MapperScan;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
//import org.springframework.jdbc.datasource.DataSourceTransactionManager;
//
//import javax.sql.DataSource;
//
//@Configuration
//@MapperScan(basePackages = "com.example.demo.dao2", sqlSessionFactoryRef = "newSqlSessionFactory")
//public class NewDataSourceConfig {
//
//    @Bean(name = "newDataSourceProperties")
//    @ConfigurationProperties(prefix = "spring.datasource.new")
//    public DataSourceProperties newDataSourceProperties() {
//        return new DataSourceProperties();
//    }
//
//    @Bean
//    public javax.sql.DataSource newDataSource(@Qualifier("newDataSourceProperties") DataSourceProperties dataSourceProperties) {
////        return DruidDataSourceBuilder.create().build();
//        return dataSourceProperties.initializeDataSourceBuilder().build();
//    }
//
//    @Bean(name = "newTransactionManager")
//    public DataSourceTransactionManager newTransactionManager(javax.sql.DataSource newDataSource) {
//        return new DataSourceTransactionManager(newDataSource);
//    }
//
//    @Bean(name = "newSqlSessionFactory")
//    public SqlSessionFactory newSqlSessionFactory(DataSource newDataSource)
//            throws Exception {
//        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
//        sessionFactory.setDataSource(newDataSource);
//        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
//                .getResources("classpath:mybatis/mapper/new/*.xml"));
//        return sessionFactory.getObject();
//    }
//}
