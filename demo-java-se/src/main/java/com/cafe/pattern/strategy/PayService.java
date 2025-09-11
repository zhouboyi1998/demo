package com.cafe.pattern.strategy;

import java.math.BigDecimal;

/**
 * @Project: demo
 * @Package: com.cafe.pattern.strategy
 * @Author: zhouboyi
 * @Date: 2024/11/04 14:39
 * @Description: 支付服务
 */
public interface PayService {

    /**
     * 支付账单
     *
     * @param amount 支付金额
     */
    void pay(BigDecimal amount);
}
