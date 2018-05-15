package com.homyo.components.mongodb.test.domin;

import java.io.Serializable;

public class UserDO implements Serializable {

    private static final long serialVersionUID = 4644818418995234652L;

    private String userName;

    private String userPwd;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }
}
