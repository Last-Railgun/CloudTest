package com.test.cloud.gateway;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.server.ServerWebExchange;

import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

@Component
@Slf4j
public class MyRoutePredicateFactory extends AbstractRoutePredicateFactory<MyRoutePredicateFactory.Config> {
    public MyRoutePredicateFactory() {
        super(MyRoutePredicateFactory.Config.class);
    }

    @Override
    public Predicate<ServerWebExchange> apply(MyRoutePredicateFactory.Config config) {
        return exchange -> {
            String userType = exchange.getRequest().getQueryParams().getFirst("userType");
            if (userType == null) return false;
            return userType.equalsIgnoreCase(config.getUserType());
        };
    }

    @Override
    public List<String> shortcutFieldOrder() {
        return Collections.singletonList("userType");
    }

    @Getter
    @Setter
    @Validated
    public static class Config {
        @NotEmpty
        private String userType;
    }
}
