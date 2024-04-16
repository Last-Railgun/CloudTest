package com.test.cloud.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.test.cloud.apis.AccountFeignApi;
import com.test.cloud.apis.StorageFeignApi;
import com.test.cloud.entities.Order;
import com.test.cloud.mapper.OrderMapper;
import com.test.cloud.service.OrderService;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {
    @Resource
    private OrderMapper orderMapper;
    //调用库存微服务
    @Resource
    private StorageFeignApi storageFeignApi;
    //调用账户微服务
    @Resource
    private AccountFeignApi accountFeignApi;

    @Override
    @GlobalTransactional(name = "create-order", rollbackFor = Exception.class)
    public Order createOrder(Order order) {
        //全局事务id检查
        String xid = RootContext.getXID();
        log.info("开始新建订单: {}", xid);
        //订单新建状态默认为0
        order.setStatus(0);
        int insResult = orderMapper.insert(order);
        Order orderFromDb = null;
        if (insResult > 0) {
            orderFromDb = orderMapper.selectById(order.getId());
            log.info("新建订单成功,订单信息为: {}", orderFromDb);
            //扣减库存
            log.info("开始调用库存微服务, 扣减库存");
            storageFeignApi.decrease(orderFromDb.getProductId(), orderFromDb.getCount());
            log.info("调用结束");
            //扣减账户余额
            log.info("开始调用账户微服务, 扣减余额");
            accountFeignApi.decrease(orderFromDb.getUserId(), orderFromDb.getMoney());
            log.info("调用结束");
            //修改订单状态
            QueryWrapper<Order> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("id", orderFromDb.getId());
            queryWrapper.eq("status", 0);
            orderFromDb.setStatus(1);
            int updResult = orderMapper.update(orderFromDb, queryWrapper);
            log.info("修改订单状态完成");
//            orderMapper.updateById(orderFromDb);
        }
        log.info("结束订单创建");
        return orderFromDb;
    }
}
