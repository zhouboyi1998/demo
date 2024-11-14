package com.cafe.pattern.state.order.status;

import com.cafe.pattern.state.order.Order;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @Project: demo
 * @Package: com.cafe.pattern.state.order.status
 * @Author: zhouboyi
 * @Date: 2024/11/14 18:24
 * @Description: {@link Canceled}
 */
public class CanceledTest {

    private Order order;

    @BeforeEach
    void setUp() {
        order = new Order();
        order.cancel();
    }

    @Test
    void confirm() {
        order.confirm();
    }

    @Test
    void pay() {
        order.pay();
    }

    @Test
    void ship() {
        order.ship();
    }

    @Test
    void delivery() {
        order.delivery();
    }

    @Test
    void receive() {
        order.receive();
    }

    @Test
    void cancel() {
        order.cancel();
    }
}
