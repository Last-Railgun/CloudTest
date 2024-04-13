package com.test.cloud.gateway;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class TimeClobalFilter implements GlobalFilter, Ordered {
    //开始调用方法的时间
    public static final String BEGIN_VISIT_TIME = "begin_visit_time";

    /**
     * 统计方法调用时间
     *
     * @param exchange the current server exchange
     * @param chain    provides a way to delegate to the next filter
     * @return
     */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        exchange.getAttributes().put(BEGIN_VISIT_TIME, System.currentTimeMillis());
        return chain.filter(exchange).then(Mono.fromRunnable(() -> {
            Long begin = exchange.getAttribute(BEGIN_VISIT_TIME);
            if (begin != null) {
                log.info("访问接口主机: {}", exchange.getRequest().getURI().getHost());
                log.info("访问接口端口: {}", exchange.getRequest().getURI().getPort());
                log.info("访问接口URL: {}", exchange.getRequest().getURI().getPath());
                log.info("访问接口参数: {}", exchange.getRequest().getURI().getRawQuery());
                log.info("访问接口时常: {}ms", System.currentTimeMillis() - begin);
            }
        }));
    }

    /**
     * 数值越小,优先越高
     *
     * @return 优先级
     */
    @Override
    public int getOrder() {
        return 0;
    }
}
