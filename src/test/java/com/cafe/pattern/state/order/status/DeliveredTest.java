package com.cafe.pattern.state.order.status;

import com.cafe.pattern.state.order.Order;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @Project: demo
 * @Package: com.cafe.pattern.state.order.status
 * @Author: zhouboyi
 * @Date: 2024/11/14 17:33
 * @Description: {@link Delivered}
 */
public class DeliveredTest {

    private Order order;

    @BeforeEach
    void setUp() {
        order = new Order();
        order.confirm();
        order.pay();
        order.ship();
        order.delivery();
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
