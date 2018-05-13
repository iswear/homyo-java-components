package com.homyo.component.datasource;

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
public class Test {

    @Resource
    private DataSource dataSource;

    @org.junit.Test
    public void injectDataSource() {
        System.out.println(dataSource);
    }

}
