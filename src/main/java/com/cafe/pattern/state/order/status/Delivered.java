package com.cafe.pattern.state.order.status;

import com.cafe.pattern.state.order.Order;
import lombok.extern.slf4j.Slf4j;

/**
 * @Project: demo
 * @Package: com.cafe.pattern.state.order.status
 * @Author: zhouboyi
 * @Date: 2024/11/14 16:48
 * @Description: 5: 已配送 / 待收货
 */
@Slf4j
public class Delivered extends OrderStatus {

    protected Delivered() {

    }

    @Override
    public void confirm(Order order) {
        log.info("order [{}] has been delivered, do not repeat confirm!", order.getId());
    }

    @Override
    public void pay(Order order) {
        log.info("order [{}] has been delivered, do not repeat pay!", order.getId());
    }

    @Override
    public void ship(Order order) {
        log.info("order [{}] has been delivered, do not repeat ship!", order.getId());
    }

    @Override
    public void delivery(Order order) {
        log.info("order [{}] has been delivered, do not repeat delivery!", order.getId());
    }

    @Override
    public void receive(Order order) {
        order.setOrderStatus(new Received());
        log.info("order [{}] receive success!", order.getId());
    }

    @Override
    public void cancel(Order order) {
        log.info("order [{}] has been delivered, can not cancel!", order.getId());
    }
}
