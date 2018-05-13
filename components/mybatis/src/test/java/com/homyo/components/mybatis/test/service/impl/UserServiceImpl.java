package com.homyo.components.mybatis.test.service.impl;

import com.homyo.components.mybatis.test.dao.UserMapper;
import com.homyo.components.mybatis.test.domin.entity.UserDO;
import com.homyo.components.mybatis.test.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Transactional(rollbackFor = Exception.class)
    public int add(UserDO user) {
        int a = userMapper.add(user);
        if (true) {
            throw new RuntimeException("runtime exception");
        } else {
            return a;
        }
    }
}
