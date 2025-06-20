package lk.ijse.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ApiGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayApplication.class, args);
    }

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("user-service", r -> r.path("/users/**")
                        .uri("lb://user-service"))
                .route("vehicle-service", r -> r.path("/vehicles/**")
                        .uri("lb://vehicle-service"))
                .route("parking-service", r -> r.path("/parking/**")
                        .uri("lb://parking-service"))
                .route("payment-service", r -> r.path("/payments/**")
                        .uri("lb://payment-service"))
                .build();
    }

}
