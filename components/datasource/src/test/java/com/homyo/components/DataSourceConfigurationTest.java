package com.homyo.components;

import com.alibaba.druid.pool.DruidDataSource;
import javax.sql.DataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSourceConfigurationTest {


    @Bean
    @ConfigurationProperties(prefix = "homyo.dataSource")
    public DataSource injectDataSource() {
        return new DruidDataSource();
    }

}
