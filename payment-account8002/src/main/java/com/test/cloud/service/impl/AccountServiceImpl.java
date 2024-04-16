package com.test.cloud.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.test.cloud.entities.Account;
import com.test.cloud.mapper.AccountMapper;
import com.test.cloud.service.AccountService;
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
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements AccountService {
    @Resource
    private AccountMapper accountMapper;

    @Override
    public void decrease(Long userId, Long money) {
        accountMapper.decreaseAccount(userId, money);
        //模拟异常,全局事务回滚
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        int n = 1 / 0;
        log.info("decrease account: {}", money);
    }
}
