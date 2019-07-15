package com.sso.entity;

import java.io.Serializable;

/**
 * 用户登录User
 *
 */
public class UserInfo implements Serializable {

    private static final long serialVersionUID = 894807669028587136L;
    private String userId;

    private String userName;

    private String password;


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
