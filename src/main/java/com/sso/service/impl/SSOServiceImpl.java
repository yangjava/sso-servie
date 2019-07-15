package com.sso.service.impl;

import com.sso.entity.ReturnT;
import com.sso.entity.UserInfo;
import com.sso.entity.UserSession;
import com.sso.service.RedisService;
import com.sso.service.SSOService;
import com.sso.service.SessionService;
import com.sso.service.UserService;
import com.sso.util.SSOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 单点登录实现类
 */
@Service
public class SSOServiceImpl implements SSOService {

    @Autowired
    private UserService userService;
    @Autowired
    private RedisService redisService;
    @Autowired
    private SessionService sessionService;

    @Override
    public ReturnT<String> doLogin(String userName, String password) {
        ReturnT<UserInfo> userInfoReturnT = userService.findByUserNameAndPassword(userName, password);
        if(!userInfoReturnT.getSuccess()){
            return new ReturnT<>(userInfoReturnT.getMsg());
        }
        UserInfo userInfo = userInfoReturnT.getData();
        UserSession userSession=new UserSession();
        userSession.setUserInfo(userInfo);
        userSession.setVersion(SSOUtil.getVersion());
        userSession.setExpireTime(SSOUtil.getExpireTime(1000L));
        String sessionId=sessionService.getSessionId(userSession);
        sessionService.getSessionId(userSession);
        redisService.set(sessionService.getSessionKey(userInfo.getUserId()),userSession,1000*60L);
        return new ReturnT<>(sessionId);
    }

    @Override
    public ReturnT<String> doLogout(String sessionId) {
        String userId = sessionService.parseUserId(sessionId);
        redisService.remove(sessionService.getSessionKey(userId));
        return new ReturnT<>(userId);
    }

    @Override
    public ReturnT<String> doCheck(String sessionId) {
        String userId = sessionService.parseUserId(sessionId);
        if(null!=userId){
            UserSession userSession=(UserSession)redisService.get(sessionService.getSessionKey(userId));
            if(userSession.getVersion().equals(sessionService.parseVersion(sessionId))){
                // After the expiration time has passed half, Auto refresh
                if ((System.currentTimeMillis() - userSession.getFreshTime()) > userSession.getExpireTime()/2) {
                    userSession.setFreshTime(System.currentTimeMillis());
                    redisService.set(sessionService.getSessionKey(userId),userSession);
                }
            }
        }
        return null;
    }
}
