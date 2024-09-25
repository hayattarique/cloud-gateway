package org.boot.cloud.filters;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class CustomGatewayFilter extends AbstractGatewayFilterFactory<CustomGatewayFilter> {
    public CustomGatewayFilter() {
        super(CustomGatewayFilter.class);
    }
    @Override
    public GatewayFilter apply(CustomGatewayFilter config) {

        return (exchange, chain) -> {
            log.info("CustomGatewayFilter apply", exchange.getRequest().getPath());
            Mono<Void> response = chain.filter(exchange);
            log.info("CustomGatewayFilter apply", exchange.getRequest().getPath());
            return response;
        };
    }
}
