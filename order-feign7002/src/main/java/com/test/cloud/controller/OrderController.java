package com.test.cloud.controller;

import com.test.cloud.apis.PayFeignApi;
import com.test.cloud.entities.Order;
import com.test.cloud.entities.TPayDTO;
import com.test.cloud.resp.ResultData;
import com.test.cloud.resp.ReturnCode;
import com.test.cloud.service.OrderService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class OrderController {
    @Resource
    private PayFeignApi payFeignApi;
    @Resource
    private OrderService orderService;

    @PostMapping("/order/create")
    public ResultData<Order> create(@RequestBody Order order) {
        return ResultData.success(orderService.createOrder(order));
    }

    @GetMapping("/order/mq")
    public ResultData<Order> createMQ() {
        return ResultData.success(orderService.createOrderMQ(new Order()));
    }

    @PostMapping("/feign/pay/add")
    public ResultData<String> addOrder(@RequestBody TPayDTO tPayDTO) {
        log.info("触发feign远程调用");
        return payFeignApi.addPay(tPayDTO);
    }

    @GetMapping("/feign/pay/get/{id}")
    public ResultData<TPayDTO> getById(@PathVariable("id") Integer id) {
        return payFeignApi.getById(id);
    }

    @GetMapping("/feign/pay/getall")
    public ResultData<List<TPayDTO>> getAll() {
        return payFeignApi.getAll();
    }

    //以下为测试接口
    @GetMapping("/feign/pay/get/info")
    public String getInfo() {
        return payFeignApi.getInfo();
    }

    @GetMapping("/feign/pay/getcir/{id}")
//    @CircuitBreaker(name = "provider-payment", fallbackMethod = "cirFallback")
//    @RateLimiter(name = "provider-payment", fallbackMethod = "cirFallback")
    public ResultData<String> getCir(@PathVariable("id") Integer id) {
//        return payFeignApi.getCir(id);
        return payFeignApi.getCir(id);
    }

    //服务降级方法
    public ResultData<String> cirFallback(Integer id, Throwable t) {
        return ResultData.fail(ReturnCode.RC500.getCode(), "Cirfallback: 已被限速,请稍后再试");
    }

    @GetMapping("/feign/pay/getmic/{id}")
    public ResultData<String> getMic(@PathVariable("id") Integer id) {
        return payFeignApi.getMic(id);
    }
}
