package com.homyo.components.datasource;

import javax.sql.DataSource;

/**
 * Created by iswear on 2018/5/6.
 */
public interface DataSourceGroup {

    DataSource get(String name);
    
}
