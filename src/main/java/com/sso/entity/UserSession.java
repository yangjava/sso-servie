package com.sso.entity;

import java.io.Serializable;
import java.util.Map;

/**
 * session中存储的用户信息
 * @author  yang
 */
public class UserSession implements Serializable {

    private static final long serialVersionUID = -7146627958094221875L;

    private String userId;

    private String userName;

    private Map<String,Object> ext;

    private String version;

    private Long expireTime;

    private Long freshTime;

    public void setUserInfo(UserInfo userInfo){
        this.userId = userInfo.getUserId();
        this.userName = userInfo.getUserName();
    }

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

    public Map<String, Object> getExt() {
        return ext;
    }

    public void setExt(Map<String, Object> ext) {
        this.ext = ext;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Long getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Long expireTime) {
        this.expireTime = expireTime;
    }

    public Long getFreshTime() {
        return freshTime;
    }

    public void setFreshTime(Long freshTime) {
        this.freshTime = freshTime;
    }
}
