package com.jeonguk.gateway.router;

import com.jeonguk.gateway.filter.ElapsedFilter;
import com.jeonguk.gateway.filter.SimpleLoggingFilter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayRoutes {

    private static final String API_SERVER_URI = "http://localhost:8081";
    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder) {
        // @formatter:off
        return builder.routes()
                .route("api_user",
                        r -> r.path("/api/user")
                        .filters(f -> {
                            f.filter(new SimpleLoggingFilter());
                            f.addRequestHeader("HEADER-SEND", "SEND_HEADER");
                            return f;
                        })
                        .uri(API_SERVER_URI))
                .route("api_hello",
                        r -> r.path("/api/hello")
                        .filters(f -> {
                                    f.filter(new SimpleLoggingFilter());
                                    f.filter(new ElapsedFilter());
                                    return f;
                                }
                        )
                        .uri(API_SERVER_URI))
                .build();
        // @formatter:on
    }

}
