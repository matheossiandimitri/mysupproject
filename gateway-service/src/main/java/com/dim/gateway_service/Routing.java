package com.dim.gateway_service;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

public class Routing {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("job-offers-service", r -> r.path("/job-offers-service/**").uri("lb://JOB-OFFERS-SERVICE"))
                .build();
    }
}
