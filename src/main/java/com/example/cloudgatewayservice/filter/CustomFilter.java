package com.example.cloudgatewayservice.filter;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractChangeRequestUriGatewayFilterFactory;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;

import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;

@Component
public class CustomFilter extends AbstractChangeRequestUriGatewayFilterFactory<CustomFilter.Config> {
    public CustomFilter() {
        super(Config.class);
    }

    @Override
    protected Optional<URI> determineRequestUri(ServerWebExchange exchange, Config config) {
        String requestUrl = exchange.getRequest().getPath().contextPath().value();
        exchange.getRequest().getHeaders();
        System.out.println(requestUrl);
        try {
            return Optional.of(new URI("https://jsonplaceholder.typicode.com/todos/1"));
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
/*

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            System.out.println("First pre filter" + exchange.getRequest());
            //Custom Post Filter.Suppose we can call error response handler based on error code.
            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                System.out.println("First post filter");
            }));
        };
    }
*/

    public static class Config {
        // Put the configuration properties
    }
}