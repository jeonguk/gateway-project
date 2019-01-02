package com.jeonguk.gateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class SimpleLoggingFilter implements GatewayFilter {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        //code for PRE filter
        log.info("Custom Filter =======================================");
        log.info("Method:{} Host:{} Path:{} QueryParams:{}",
                exchange.getRequest().getMethod(),
                exchange.getRequest().getURI().getHost(),
                exchange.getRequest().getURI().getPath(),
                exchange.getRequest().getQueryParams());
        Mono<Void> v = chain.filter(exchange);
        //code for POST filter
        //exchange.getResponse().setStatusCode(HttpStatus.OK);
        return v;
    }
}
