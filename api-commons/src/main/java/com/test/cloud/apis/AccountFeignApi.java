package com.test.cloud.apis;

import com.test.cloud.resp.ResultData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("payment-account")
public interface AccountFeignApi {
    /**
     * 扣除余额
     *
     * @param userId 用户id
     * @param money  用户余额
     * @return
     */
    @PostMapping("/account/decrease")
    ResultData<String> decrease(@RequestParam("userId") Long userId, @RequestParam("money") Long money);
}
