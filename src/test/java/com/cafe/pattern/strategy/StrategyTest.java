package com.cafe.pattern.strategy;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

/**
 * @Project: demo
 * @Package: com.cafe.pattern.strategy
 * @Author: zhouboyi
 * @Date: 2024/11/04 15:10
 * @Description: {@link PayContext}
 */
@Slf4j
public class StrategyTest {

    private static PayContext payContext;

    @BeforeAll
    static void setUp() {
        payContext = new PayContext();
    }

    @Test
    void aliPay() {
        payContext.getPayService(AliPayServiceImpl.class.getSimpleName())
            .pay(BigDecimal.valueOf(99.8));
    }

    @Test
    void wechatPay() {
        payContext.getPayService(WeChatPayServiceImpl.class.getSimpleName())
            .pay(BigDecimal.valueOf(99.8));
    }

    @Test
    void bandCardPay() {
        payContext.getPayService(BandCardPayServiceImpl.class.getSimpleName())
            .pay(BigDecimal.valueOf(99.8));
    }

    @Test
    void creditCardPay() {
        // 断言: 获取不支持的支付服务时, 抛出 IllegalArgumentException 异常
        IllegalArgumentException e = Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> payContext.getPayService("creditCardPayServiceImpl")
                .pay(BigDecimal.valueOf(99.8))
        );
        log.info("{}", e.getMessage());
    }
}
