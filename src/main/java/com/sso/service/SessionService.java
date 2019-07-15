package com.sso.service;

import com.sso.entity.UserSession;

public interface SessionService {

    String getSessionId(UserSession userSession);

    String getSessionKey(String userId);

    Long getExpireTime(Long expire);

    String parseUserId(String sessionId);

    String  parseVersion(String sessionId);
}
