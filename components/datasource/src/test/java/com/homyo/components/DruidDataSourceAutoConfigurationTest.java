package com.homyo.components;

import com.homyo.components.datasource.DataSourceGroup;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * Created by iswear on 2018/5/5.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApplicationTest.class)
public class DruidDataSourceAutoConfigurationTest {

    @Resource
    private DataSource dataSource;

    @Resource
    private DataSourceGroup dataSourceGroup;

    @Test
    public void injectDataSource() {
        System.out.println(dataSource);
        System.out.println(dataSourceGroup);
    }

}