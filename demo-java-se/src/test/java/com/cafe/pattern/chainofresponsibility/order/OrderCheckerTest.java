package com.cafe.pattern.chainofresponsibility.order;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @Project: demo
 * @Package: com.cafe.pattern.chainofresponsibility.order
 * @Author: zhouboyi
 * @Date: 2025/9/15 14:28
 * @Description: {@link Client}
 */
public class OrderCheckerTest {

    private Client client;

    private Order order;

    @BeforeEach
    void setUp() {
        client = new Client();
        order = new Order()
            .setUserId(1L)
            .setGoodsId(1L)
            .setCount(3)
            .setAddressId(1L);
    }

    @Test
    void checkOrder() {
        boolean checked = client.checkOrder(order);
        System.out.println(checked);
    }
}
