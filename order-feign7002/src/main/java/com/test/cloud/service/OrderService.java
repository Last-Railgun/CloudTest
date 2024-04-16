package com.test.cloud.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.test.cloud.entities.Order;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author LastRailgun
 * @since 2024-04-16
 */
public interface OrderService extends IService<Order> {
    Order createOrder(Order order);
}
