package com.test.cloud.service.impl;

import com.test.cloud.entities.TPay;
import com.test.cloud.mapper.TPayMapper;
import com.test.cloud.service.PayService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PayServiceImpl implements PayService {
    @Resource
    private TPayMapper tPayMapper;

    @Override
    public Integer add(TPay tPay) {
        return tPayMapper.insert(tPay);
    }

    @Override
    public Integer del(Integer id) {
        return tPayMapper.deleteById(id);
    }

    @Override
    public Integer upd(TPay tPay) {
        return tPayMapper.updateById(tPay);
    }

    @Override
    public TPay getById(Integer id) {
        return tPayMapper.selectById(id);
    }

    @Override
    public List<TPay> selectAll() {
        return tPayMapper.selectAll();
    }
}
