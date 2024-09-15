package com.dim.gateway_service.routers;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

public class JobOffersServiceRouter {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/job-offers-service")
                        // remove service name
                        .filters(f -> f.stripPrefix(1))
                        .uri("lb://job-offers-service"))
                .build();
    }
}
