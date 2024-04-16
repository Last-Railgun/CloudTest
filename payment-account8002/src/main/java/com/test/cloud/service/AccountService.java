package com.test.cloud.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.test.cloud.entities.Account;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author LastRailgun
 * @since 2024-04-16
 */
public interface AccountService extends IService<Account> {
    void decrease(Long userId, Long money);
}
