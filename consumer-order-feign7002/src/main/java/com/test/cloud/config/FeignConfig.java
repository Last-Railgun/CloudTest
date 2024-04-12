package com.test.cloud.config;

import feign.Logger;
import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {
    @Bean
    Logger.Level feignLogLevel() {
        return Logger.Level.FULL;
    }

    @Bean
    public Retryer retryer() {
//        return Retryer.NEVER_RETRY;
        return new Retryer.Default(100, 1, 3);
    }
}
