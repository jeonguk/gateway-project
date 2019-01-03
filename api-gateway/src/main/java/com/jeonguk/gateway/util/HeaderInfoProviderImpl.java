package com.jeonguk.gateway.util;

import com.jeonguk.gateway.config.HeaderInfoProvider;
import com.jeonguk.gateway.enums.AppHeader;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.server.ServerWebExchange;

import java.time.LocalDateTime;

import static java.time.LocalDateTime.now;

@Slf4j
@Component
@RequestScope
@Getter
public class HeaderInfoProviderImpl implements HeaderInfoProvider {

    private final String userNm;
    private final String authToken;
    private final LocalDateTime requestDateTime;

    @Autowired
    public HeaderInfoProviderImpl(ServerWebExchange exchange) {
        this.userNm = getHeader(exchange, AppHeader.USER_NM);
        this.authToken = getHeader(exchange, AppHeader.AUTO_TOKEN);
        this.requestDateTime = now();
    }

    private String getHeader(ServerWebExchange exchange, AppHeader appHeader) {
        ServerHttpRequest request = exchange.getRequest();
        HttpHeaders headers = request.getHeaders();
        return headers.getFirst(appHeader.getFieldName());
    }

}
