package com.homyo.components.datasource.druid;

import java.io.Serializable;
import java.util.Map;

/**
 * Created by iswear on 2018/5/6.
 */
public class DruidDataSourceGroupConfig implements Serializable {

    private static final long serialVersionUID = -5103128982664439143L;

    private Map<String, DruidDataSourceConfig> dataSources;

    public Map<String, DruidDataSourceConfig> getDataSources() {
        return dataSources;
    }

    public void setDataSources(Map<String, DruidDataSourceConfig> dataSources) {
        this.dataSources = dataSources;
    }
}
