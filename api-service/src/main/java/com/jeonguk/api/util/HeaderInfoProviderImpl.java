package com.jeonguk.api.util;

import com.jeonguk.api.config.HeaderInfoProvider;
import com.jeonguk.api.enums.AppHeader;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

import static java.time.LocalDateTime.now;

@Slf4j
@Component
@Scope(scopeName = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.INTERFACES)
@Getter
public class HeaderInfoProviderImpl implements HeaderInfoProvider {

    private final String userNm;
    private final String authToken;
    private final LocalDateTime requestDateTime;

    @Autowired
    public HeaderInfoProviderImpl(HttpServletRequest request) {
        this.userNm = getHeader(request, AppHeader.USER_NM);
        this.authToken = getHeader(request, AppHeader.AUTH_TOKEN);
        this.requestDateTime = now();
    }

    private String getHeader(HttpServletRequest request, AppHeader appHeader) {
        return request.getHeader(appHeader.getFieldName());
    }


}
