package com.cafe.pattern.state.order;

import org.junit.jupiter.api.Test;

/**
 * @Project: demo
 * @Package: com.cafe.pattern.state.order
 * @Author: zhouboyi
 * @Date: 2024/11/14 17:01
 * @Description: {@link Order}
 */
public class OrderTest {

    @Test
    void test() {
        Order order = new Order();
        order.confirm();
        order.pay();
        order.ship();
        order.delivery();
        order.receive();
        order.cancel();
    }
}
