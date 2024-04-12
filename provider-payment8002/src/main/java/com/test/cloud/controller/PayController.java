package com.test.cloud.controller;

import com.test.cloud.entities.TPay;
import com.test.cloud.entities.TPayDTO;
import com.test.cloud.resp.ResultData;
import com.test.cloud.service.PayService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
//        TimeUnit.SECONDS.sleep(6);
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

}
