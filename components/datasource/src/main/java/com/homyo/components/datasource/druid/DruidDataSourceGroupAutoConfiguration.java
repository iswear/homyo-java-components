package com.homyo.components.datasource.druid;

import com.alibaba.druid.pool.DruidDataSource;
import com.homyo.components.datasource.DataSourceGroup;
import org.apache.commons.collections4.MapUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author iswear
 * @date 2018/5/5
 */
@Configuration
@ConditionalOnProperty(name = "homyo.dataSourceGroup.type", havingValue = "druid")
public class DruidDataSourceGroupAutoConfiguration {

    @Bean
    @ConfigurationProperties(prefix = "homyo.dataSourceGroup.config")
    public DruidDataSourceGroupConfig injectDataSourceGroupConfig() {
        return new DruidDataSourceGroupConfig();
    }

    @Bean
    public DataSourceGroup injectDataSourceGroup(DruidDataSourceGroupConfig config) throws SQLException {
        DruidDataSourceGroup group = new DruidDataSourceGroup();
        if (MapUtils.isNotEmpty(config.getDataSources())) {
            Map<String, DataSource> dataSources = new HashMap<>();
            Set<String> keys = config.getDataSources().keySet();
            for (String key : keys) {
                DruidDataSourceConfig dsConf = config.getDataSources().get(key);
                DruidDataSource ds = new DruidDataSource();
                BeanUtils.copyProperties(dsConf, ds);
                dataSources.put(key, ds);
            }
            group.setDataSources(dataSources);
        } else {
            group.setDataSources(Collections.emptyMap());
        }
        return group;
    }
}
