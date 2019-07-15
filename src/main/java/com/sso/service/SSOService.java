package com.sso.service;

import com.sso.entity.ReturnT;

public interface SSOService {

    /**
     * 单点登录接口
     * @param userName
     * @param password
     * @return
     */
    ReturnT<String> doLogin(String userName, String password);

    /**
     * 单点登录退出接口
     * @param sessionId
     * @return
     */
    ReturnT<String> doLogout(String sessionId);

    /**
     * 单点登录校验接口
     * @param sessionId
     * @return
     */
    ReturnT<String> doCheck(String sessionId);

}
