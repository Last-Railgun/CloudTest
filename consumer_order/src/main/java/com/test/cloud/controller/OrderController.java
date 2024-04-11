package com.test.cloud.controller;

import com.test.cloud.entities.TPayDTO;
import com.test.cloud.resp.ResultData;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class OrderController {
    public static final String Payment_Url = "http://localhost:8001";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/pay/add")
    public ResultData addOrder(TPayDTO tPayDTO) {
        return restTemplate.postForObject(Payment_Url + "/pay/add", tPayDTO, ResultData.class);
    }

    @GetMapping("consumer/pay/get/{id}")
    public ResultData getOrder(@PathVariable("id") Integer id) {
        log.info("触发consumer查询");
        return restTemplate.getForObject(Payment_Url + "/pay/get/" + id, ResultData.class, id);
    }

}
