package com.sso.service.impl;

import com.sso.entity.UserSession;
import com.sso.service.SessionService;
import org.springframework.stereotype.Service;

@Service
public class SessionServiceImpl implements SessionService {


    @Override
    public String getSessionId(UserSession userSession) {
        return userSession.getUserId().concat("_").concat(userSession.getVersion());
    }

    @Override
    public String getSessionKey(String userId) {
        return "sso_session".concat("_").concat(userId);
    }

    @Override
    public Long getExpireTime(Long expire) {
        return null;
    }

    @Override
    public String parseUserId(String sessionId) {
        if (sessionId!=null && sessionId.indexOf("_")>-1) {
            String[] sessionIdArr = sessionId.split("_");
            if (sessionIdArr.length==2
                    && sessionIdArr[0]!=null
                    && sessionIdArr[0].trim().length()>0) {
                String userId = sessionIdArr[0].trim();
                return userId;
            }
        }
        return null;
    }

    @Override
    public String parseVersion(String sessionId) {
        if (sessionId!=null && sessionId.indexOf("_")>-1) {
            String[] sessionIdArr = sessionId.split("_");
            if (sessionIdArr.length==2
                    && sessionIdArr[1]!=null
                    && sessionIdArr[1].trim().length()>0) {
                String version = sessionIdArr[1].trim();
                return version;
            }
        }
        return null;
    }


}
