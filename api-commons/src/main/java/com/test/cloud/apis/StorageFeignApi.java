package com.test.cloud.apis;

import com.test.cloud.resp.ResultData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("payment-storage")
public interface StorageFeignApi {
    /**
     * 扣除库存
     *
     * @param productId 库存id
     * @param count     库存量
     * @return
     */
    @PostMapping("/storage/decrease")
    ResultData<String> decrease(@RequestParam("productId") Long productId, @RequestParam("count") Integer count);
}
