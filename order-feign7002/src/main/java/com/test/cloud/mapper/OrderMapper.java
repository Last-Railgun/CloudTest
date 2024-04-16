package com.test.cloud.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.test.cloud.entities.Order;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author LastRailgun
 * @since 2024-04-16
 */
@Mapper
public interface OrderMapper extends BaseMapper<Order> {

}
