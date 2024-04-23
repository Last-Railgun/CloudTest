package com.test.cloud.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.test.cloud.entities.Account;

import java.util.Map;

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

    void decreaseMQ(Map<String, Object> msg);
}
