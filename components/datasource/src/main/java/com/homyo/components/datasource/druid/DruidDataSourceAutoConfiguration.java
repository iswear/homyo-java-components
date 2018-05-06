package com.homyo.components.datasource.druid;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author iswear
 * @date 2018/5/5
 */
@Configuration
@ConditionalOnProperty(name = "homyo.dataSource.type", havingValue = "druid")
public class DruidDataSourceAutoConfiguration {

    @Bean
    @ConfigurationProperties(prefix = "homyo.dataSource.config")
    public DruidDataSourceConfig injectDataSourceConfig() {
        return new DruidDataSourceConfig();
    }

    @Bean
    public DataSource injectDataSource(DruidDataSourceConfig config) {
        DruidDataSource dataSource = new DruidDataSource();
        BeanUtils.copyProperties(config, dataSource);
        return dataSource;
    }
}
