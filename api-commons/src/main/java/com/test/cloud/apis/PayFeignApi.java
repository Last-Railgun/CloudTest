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

@FeignClient(value = "provider-payment", fallback = PayFeignApiFallBack.class)
//@FeignClient("gateway")
//该注解的blockhandler, fallback方法需要保证返回类型和参数列表一致,且参数列表要多一个BlockException参数
//上述两个注解参数可以共存, 前者处理限流, 后者处理程序内异常
//@SentinelResource(value = "payment", blockHandlerClass = PayFeiApiFallBack.class)
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
    ResultData<String> getFilter(HttpServletRequest request);
}
