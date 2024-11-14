package com.cafe.pattern.state.order.status;

import com.cafe.pattern.state.order.Order;
import lombok.extern.slf4j.Slf4j;

/**
 * @Project: demo
 * @Package: com.cafe.pattern.state.order.status
 * @Author: zhouboyi
 * @Date: 2024/11/14 16:47
 * @Description: 4: 已发货 / 待配送
 */
@Slf4j
public class Shipped extends OrderStatus {

    protected Shipped() {

    }

    @Override
    public void confirm(Order order) {
        log.info("order [{}] has been shipped, do not repeat confirm!", order.getId());
    }

    @Override
    public void pay(Order order) {
        log.info("order [{}] has been shipped, do not repeat pay!", order.getId());
    }

    @Override
    public void ship(Order order) {
        log.info("order [{}] has been shipped, do not repeat ship!", order.getId());
    }

    @Override
    public void delivery(Order order) {
        order.setOrderStatus(new Delivered());
        log.info("order [{}] delivery success!", order.getId());
    }

    @Override
    public void receive(Order order) {
        log.info("order [{}] is not delivery, can not be receive!", order.getId());
    }

    @Override
    public void cancel(Order order) {
        log.info("order [{}] has been shipped, can not cancel!", order.getId());
    }
}
