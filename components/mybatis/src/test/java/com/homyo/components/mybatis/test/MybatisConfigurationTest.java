package com.homyo.components.mybatis.test;

import com.alibaba.druid.pool.DruidDataSource;
import javax.sql.DataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * Created by iswear on 2018/5/6.
 */
@Configuration
@MapperScan(basePackages = "com.homyo.components.mybatis.test.dao",
        sqlSessionFactoryRef = "injectSqlSessionFactoryBean",
        sqlSessionTemplateRef = "injectSqlSessionTemplate")
public class MybatisConfigurationTest {

    @Bean
    @ConfigurationProperties(prefix = "homyo.datasource")
    public DataSource injectDataSource() {
        return new DruidDataSource();
    }

    @Bean
    public PlatformTransactionManager injectTransactionManager() {
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
        transactionManager.setDataSource(injectDataSource());
        return transactionManager;
    }

    @Bean
    public SqlSessionFactory injectSqlSessionFactoryBean() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(injectDataSource());
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        factoryBean.setMapperLocations(resolver.getResources("classpath*:mybatis/mapper/**/*.xml"));
        return factoryBean.getObject();
    }

    @Bean
    public SqlSessionTemplate injectSqlSessionTemplate() throws Exception {
        SqlSessionTemplate template = new SqlSessionTemplate(injectSqlSessionFactoryBean());
        return template;
    }
}
