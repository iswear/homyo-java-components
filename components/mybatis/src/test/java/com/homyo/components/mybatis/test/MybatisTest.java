package com.homyo.components.mybatis.test;

import com.homyo.components.mybatis.ApplicationTest;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * Created by iswear on 2018/5/6.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApplicationTest.class)
public class MybatisTest {

    @Resource
    private SqlSessionFactory factory;

    @Test
    public void test() {
        System.out.println(factory);
    }

}
