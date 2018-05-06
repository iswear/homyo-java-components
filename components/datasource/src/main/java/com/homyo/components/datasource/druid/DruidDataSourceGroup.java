package com.homyo.components.datasource.druid;

import com.homyo.components.datasource.DataSourceGroup;

import javax.sql.DataSource;
import java.util.Map;

/**
 * Created by iswear on 2018/5/6.
 */
public class DruidDataSourceGroup implements DataSourceGroup {

    private Map<String, DataSource> dataSources;

    public DataSource get(String name) {
        return dataSources.get(name);
    }

    public Map<String, DataSource> getDataSources() {
        return dataSources;
    }

    public void setDataSources(Map<String, DataSource> dataSources) {
        this.dataSources = dataSources;
    }
}
