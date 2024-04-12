package com.test.cloud.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.test.cloud.entities.TPay;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 支付交易表 Mapper 接口
 * </p>
 *
 * @author LastRailgun
 * @since 2024-04-11
 */
@Mapper
public interface TPayMapper extends BaseMapper<TPay> {
    List<TPay> selectAll();
}
