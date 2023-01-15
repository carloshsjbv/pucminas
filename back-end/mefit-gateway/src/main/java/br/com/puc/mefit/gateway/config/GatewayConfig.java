package br.com.puc.mefit.gateway.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Value("${mefit.workout.service.host:http://localhost:8080}")
    private String workoutServiceHost;

    @Value("${mefit.user.service.host:http://localhost:8081}")
    private String userServiceHost;


    @Bean
    public RouteLocator myRoutes(
            RouteLocatorBuilder builder
    ) {
        return builder
                .routes()
                .route(
                        route -> route
                                .path(
                                        "/mefit/v1/workout-plans/**"
                                )
                                //.filters(filter -> filter.addRequestHeader("Hello", "World"))
                                .uri(workoutServiceHost)
                )
                .route(
                        route -> route
                                .path(
                                        "/mefit/v1/exercises/**"
                                )
                                //.filters(filter -> filter.changeRequestUri("/exercises"))
                                .uri(workoutServiceHost)
                )
                .route(
                        route -> route
                                .path(
                                        "/mefit/users",
                                        "/mefit/users/{UserId}",
                                        "/mefit/users/{login}",
                                        "/mefit/users/{statusId}/{userTypeId}"
                                )
                                //.filters(filter -> filter.addRequestHeader("Hello", "World"))
                                .uri(userServiceHost)
                )
                .build();
    }

}
