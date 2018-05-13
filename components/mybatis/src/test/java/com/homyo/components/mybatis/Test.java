package com.homyo.components.mybatis;

import com.homyo.components.mybatis.test.dao.UserMapper;
import com.homyo.components.mybatis.test.domin.entity.UserDO;
import com.homyo.components.mybatis.test.service.UserService;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@SpringBootTest
@RunWith(SpringRunner.class)
public class Test {

    @Resource
    private UserMapper userMapper;

    @Resource
    private UserService userService;

    @org.junit.Test
    public void add() {
        UserDO user = new UserDO();
        user.setUserName("name");
        user.setUserPwd("123456");
        userService.add(user);
    }

}
