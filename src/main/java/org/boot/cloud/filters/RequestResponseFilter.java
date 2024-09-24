package org.boot.cloud.filters;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class RequestResponseFilter implements GlobalFilter {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("RequestResponseFilter{}", exchange.getRequest().getPath());

        Mono<Void> res = chain.filter(exchange);
        log.info("RequestResponseFilter{}", exchange.getResponse().getStatusCode());
        return res;
    }
}
