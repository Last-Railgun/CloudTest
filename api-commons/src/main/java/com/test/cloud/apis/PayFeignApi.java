package com.test.cloud.apis;

import com.test.cloud.entities.TPayDTO;
import com.test.cloud.resp.ResultData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient("provider-payment")
public interface PayFeignApi {
    @PostMapping("/pay/add")
    ResultData<String> addPay(@RequestBody TPayDTO tPayDTO);

    @GetMapping("/pay/get/{id}")
    ResultData<TPayDTO> getById(@PathVariable("id") Integer id);

    @GetMapping("/pay/getall")
    ResultData<List<TPayDTO>> getAll();

    @GetMapping("/pay/get/info")
    String getInfo();
}
