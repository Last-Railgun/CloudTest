package com.test.cloud.controller;

import cn.hutool.core.date.DateUtil;
import com.test.cloud.entities.TPay;
import com.test.cloud.entities.TPayDTO;
import com.test.cloud.resp.ResultData;
import com.test.cloud.service.PayService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Slf4j
@RestController
public class PayController {
    @Resource
    private PayService payService;
    @Value("${server.port}")
    private String port;

    @GetMapping("/pay/get/info")
    public String getInfoByConsul(@Value("${cloudtest.info}") String info) {
        return "info:" + info + ",port:" + port;
    }

    @PostMapping("/pay/add")
    public ResultData<String> addPay(@RequestBody TPay tPay) {
        System.out.println(tPay);
        int result = payService.add(tPay);
        return ResultData.success("成功插入 " + result + " 条");
    }

    @GetMapping("/pay/del/{id}")
    public ResultData<Integer> delPay(@PathVariable("id") Integer id) {
        return ResultData.success(payService.del(id));
    }

    @PostMapping("/pay/upd")
    public ResultData<Integer> updPay(@RequestBody TPayDTO tPayDTO) {
        TPay tPay = new TPay();
        BeanUtils.copyProperties(tPayDTO, tPay);
        return ResultData.success(payService.upd(tPay));
    }

    @GetMapping("/pay/get/{id}")
    public ResultData<TPay> getPay(@PathVariable("id") Integer id) throws InterruptedException {
        if (id < 0) throw new RuntimeException("id不可为负");
        return ResultData.success(payService.getById(id));
    }

    @GetMapping("/pay/getall")
    public ResultData<List<TPay>> getPayAll() {
//        拷贝ListA泛型对象的属性到ListB泛型对象的属性
//        List<TPayDTO> tPayDTOS = new ArrayList<>();
//        payService.selectAll().stream().map(tpay -> {
//            TPayDTO tPayDTO = new TPayDTO();
//            BeanUtils.copyProperties(tpay, tPayDTO);
//            return tPayDTO;
//        }).forEach(tPayDTOS::add);
        return ResultData.success(payService.selectAll());
    }

    //以下为测试服务熔断接口
    @GetMapping("/pay/getcir/{id}")
    public ResultData<String> getCir(@PathVariable("id") Integer id) throws InterruptedException {
        if (id < 0) throw new RuntimeException("cir id 异常抛出");
        if (id > 10) TimeUnit.SECONDS.sleep(5);
        log.info("请求进入, 时间: {}", DateUtil.format(DateUtil.date(), "mm:ss"));
        return ResultData.success("your cir id is " + id);
    }
    
    @GetMapping("/pay/getrate/{id}")
    public ResultData<String> getRatelimit(@PathVariable("id") Integer id) throws InterruptedException {
        return ResultData.success("your rate limit is " + id);
    }

    //以下为测试链路追踪接口
    @GetMapping("/pay/getmic/{id}")
    public ResultData<String> getMic(@PathVariable("id") Integer id) {
        return ResultData.success("your mic is " + id);
    }

    //以下为测试网关接口
    @GetMapping("/pay/getgate/{id}")
    public ResultData<String> getGate(@PathVariable("id") Integer id) {
        return ResultData.success("your gate is " + id);
    }

    @GetMapping("/pay/getfilter")
    public ResultData<String> getFilter(HttpServletRequest request) {
        log.info("request comId: {}", request.getParameter("comId"));
        log.info("request comName: {}", request.getParameter("comName"));
        return ResultData.success("your filter is " + DateUtil.now());
    }
}
