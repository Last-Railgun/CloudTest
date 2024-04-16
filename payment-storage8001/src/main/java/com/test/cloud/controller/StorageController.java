package com.test.cloud.controller;

import com.test.cloud.resp.ResultData;
import com.test.cloud.service.StorageService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author LastRailgun
 * @since 2024-04-16
 */
@RestController
@RequestMapping("/storage")
public class StorageController {
    @Resource
    private StorageService storageService;

    @PostMapping("/decrease")
    public ResultData<String> decrease(@RequestParam("productId") Long productId, @RequestParam("count") Integer count) {
        storageService.decrease(productId, count);
        return ResultData.success("扣减库存成功");
    }
}
