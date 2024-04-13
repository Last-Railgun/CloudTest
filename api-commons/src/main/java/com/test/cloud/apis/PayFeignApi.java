package com.test.cloud.apis;

import com.test.cloud.entities.TPayDTO;
import com.test.cloud.resp.ResultData;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

//@FeignClient("provider-payment")
@FeignClient("gateway")
public interface PayFeignApi {
    @PostMapping("/pay/add")
    ResultData<String> addPay(@RequestBody TPayDTO tPayDTO);

    @GetMapping("/pay/get/{id}")
    ResultData<TPayDTO> getById(@PathVariable("id") Integer id);

    @GetMapping("/pay/getall")
    ResultData<List<TPayDTO>> getAll();

    //以下为测试接口
    @GetMapping("/pay/get/info")
    String getInfo();

    @GetMapping("/pay/getcir/{id}")
    ResultData<String> getCir(@PathVariable("id") Integer id);

    @GetMapping("/pay/getrate/{id}")
    ResultData<String> getRatelimit(@PathVariable("id") Integer id);

    @GetMapping("/pay/getmic/{id}")
    ResultData<String> getMic(@PathVariable("id") Integer id);

    @GetMapping("/pay/getfilter")
    public ResultData<String> getFilter(HttpServletRequest request);
}
