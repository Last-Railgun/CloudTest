package com.test.cloud.controller;

import com.test.cloud.apis.PayFeignApi;
import com.test.cloud.entities.TPayDTO;
import com.test.cloud.resp.ResultData;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class OrderController {
    //    public static final String Payment_Url = "http://provider-payment";
    @Resource
    private PayFeignApi payFeignApi;

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

    @GetMapping("/feign/pay/get/info")
    public String getInfo() {
        return payFeignApi.getInfo();
    }
}
