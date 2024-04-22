package com.test.cloud.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.test.cloud.entities.Storage;
import com.test.cloud.mapper.StorageMapper;
import com.test.cloud.service.StorageService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author LastRailgun
 * @since 2024-04-16
 */
@Service
@Slf4j
public class StorageServiceImpl extends ServiceImpl<StorageMapper, Storage> implements StorageService {
    @Resource
    private StorageMapper storageMapper;

    @Override
    public void decrease(Long productId, Integer count) {
        storageMapper.decreaseStorage(productId, count);
        log.info("decrease storage: {}", count);
    }

    @Override
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "direct.storage"),
            exchange = @Exchange(name = "cloud.direct", type = ExchangeTypes.DIRECT),
            key = "storage"
    ))
    public void decreaseMQ(Map<String, Object> msg) {
//        storageMapper.decreaseStorage(productId, count);
        log.info("decrease storage: {}", msg);
    }
}
