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
//@MapperScan(basePackages = "com.example.demo.dao", sqlSessionFactoryRef = "oldSqlSessionFactory")
//public class OldDataSourceConfig {
//    @Bean(name = "oldDataSourceProperties")
//    @ConfigurationProperties(prefix = "spring.datasource.old")
//    public DataSourceProperties oldDataSourceProperties() {
//        return new DataSourceProperties();
//    }
//
//
//    @Bean
//    public DataSource oldDataSource(@Qualifier("oldDataSourceProperties") DataSourceProperties dataSourceProperties) {
////        return DruidDataSourceBuilder.create().build();
//        return dataSourceProperties.initializeDataSourceBuilder().build();
//    }
//
//    @Bean(name = "oldTransactionManager")
//    public DataSourceTransactionManager oldTransactionManager(DataSource oldDataSource) {
//        return new DataSourceTransactionManager(oldDataSource);
//    }
//
//    @Bean(name = "oldSqlSessionFactory")
//    public SqlSessionFactory oldSqlSessionFactory(DataSource oldDataSource)
//            throws Exception {
//        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
//        sessionFactory.setDataSource(oldDataSource);
//        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
//                .getResources("classpath:mybatis/mapper/old/*.xml"));
//        return sessionFactory.getObject();
//    }
//
//}
