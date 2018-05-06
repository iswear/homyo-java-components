package com.homyo.components.mybatis;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScannerRegistrar;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author iswear
 * @date 2018/5/5
 */
@Configuration
public class MybatisAutoConfiguration {

    @Bean
    public SqlSessionFactory injectSqlSessionFactory() throws Exception {
        SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
        return factory.getObject();
    }

    @Bean
    public SqlSessionTemplate injectSqlSessionTemplate(SqlSessionFactory factory) {
        SqlSessionTemplate template = new SqlSessionTemplate(factory);
        return template;
    }

    @Bean
    public MapperFactoryBean injectMapperFactoryBean() {
        return new MapperFactoryBean();
    }

    @Bean
    public MapperScannerRegistrar injectScannerRegistrar() {
        return new MapperScannerRegistrar();
    }

}
