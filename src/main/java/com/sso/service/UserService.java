package com.sso.service;

import com.sso.entity.ReturnT;
import com.sso.entity.UserInfo;

public interface UserService {

    ReturnT<UserInfo> findByUserNameAndPassword(String userName,String password);
}
