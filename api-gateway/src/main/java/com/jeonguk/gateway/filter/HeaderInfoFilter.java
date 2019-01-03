package com.jeonguk.gateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class HeaderInfoFilter implements WebFilter {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        long startTime = System.currentTimeMillis();
        String path = exchange.getRequest().getURI().getPath();
        log.info("Serving '{}'", path);
        HttpHeaders headers = exchange.getRequest().getHeaders();
        headers.forEach((name, values) -> values.forEach(value -> log.info("HEAER name {}, value {}", name, value)));

        return chain.filter(exchange).doAfterTerminate(() -> {
                exchange.getResponse().getHeaders().entrySet().forEach(e ->
                    log.info("Response header '{}': {}", e.getKey(), e.getValue()));

                log.info("Served '{}' as {} in {} msec", path, exchange.getResponse().getStatusCode(), System.currentTimeMillis() - startTime);
            }
        );
    }
}
