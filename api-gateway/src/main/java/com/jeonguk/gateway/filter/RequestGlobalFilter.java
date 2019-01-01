package com.jeonguk.gateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.net.URI;

@Slf4j
@Component
public class RequestGlobalFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("Global Filter ===========================================");
//        String token = exchange.getRequest().getQueryParams().getFirst("authToken");
//        if (token == null || token.isEmpty()) {
//            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
//            return exchange.getResponse().setComplete();
//        }

        ServerHttpRequest request = exchange.getRequest();
        HttpMethod method = request.getMethod();
        log.info("HttpMethod {}", method);

        HttpHeaders headers = request.getHeaders();
        headers.forEach((name, values) -> values.forEach(value -> log.info("HEAER name {}, value {}", name, value)));

        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return -200;
    }

}
