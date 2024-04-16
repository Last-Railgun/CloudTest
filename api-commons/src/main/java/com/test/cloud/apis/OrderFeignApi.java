package com.test.cloud.apis;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("provider-payment")
public interface OrderFeignApi {
}
