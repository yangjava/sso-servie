package com.sso.util;

import java.util.UUID;

public class SSOUtil {


    public static String getVersion(){
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    public static Long getExpireTime(Long expireTime){
        return expireTime;
    }
}
