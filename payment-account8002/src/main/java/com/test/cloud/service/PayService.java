package com.test.cloud.service;

import com.test.cloud.entities.TPay;

import java.util.List;

public interface PayService {
    Integer add(TPay tPay);

    Integer del(Integer id);

    Integer upd(TPay tPay);

    TPay getById(Integer id);

    List<TPay> selectAll();
}
