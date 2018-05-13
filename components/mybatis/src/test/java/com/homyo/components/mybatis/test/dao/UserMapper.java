package com.homyo.components.mybatis.test.dao;

import com.homyo.components.mybatis.test.domin.entity.UserDO;

/**
 * Created by iswear on 2018/5/6.
 */
public interface UserMapper {

    int add(UserDO user);

}
