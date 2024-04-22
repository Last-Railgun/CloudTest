package com.test.cloud.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.test.cloud.entities.Storage;

import java.util.Map;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author LastRailgun
 * @since 2024-04-16
 */
public interface StorageService extends IService<Storage> {
    void decrease(Long productId, Integer count);

    void decreaseMQ(Map<String, Object> msg);
}
