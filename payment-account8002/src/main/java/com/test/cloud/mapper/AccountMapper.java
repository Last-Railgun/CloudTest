package com.test.cloud.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.test.cloud.entities.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author LastRailgun
 * @since 2024-04-16
 */
@Mapper
public interface AccountMapper extends BaseMapper<Account> {
    void decreaseAccount(@Param("userId") Long userId, @Param("money") Long money);
}
