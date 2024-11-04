package com.cafe.pattern.strategy;

import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

/**
 * @Project: demo
 * @Package: com.cafe.pattern.strategy
 * @Author: zhouboyi
 * @Date: 2024/11/04 14:42
 * @Description: 银行卡 支付服务实现类
 */
@Slf4j
public class BandCardPayServiceImpl implements PayService {

    @Override
    public void pay(BigDecimal amount) {
        log.info("Band Card Pay: You have paid ${}", amount);
    }
}
