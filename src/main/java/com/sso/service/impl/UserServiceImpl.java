package com.sso.service.impl;

import com.sso.entity.ReturnT;
import com.sso.entity.UserInfo;
import com.sso.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {


    @Override
    public ReturnT<UserInfo> findByUserNameAndPassword(String userName, String password) {
        UserInfo userInfo=new UserInfo();
        userInfo.setPassword("xxx");
        userInfo.setUserName("12345");
        if(userInfo.getUserName().equals(userName)&&userInfo.getPassword().equals(password)){
        return new ReturnT<>(userInfo);
        }
        return new ReturnT<>("UserName or Password is Invalid !");
    }
}
