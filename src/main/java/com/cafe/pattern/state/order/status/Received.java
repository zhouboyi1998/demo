package com.cafe.pattern.state.order.status;

import com.cafe.pattern.state.order.Order;
import lombok.extern.slf4j.Slf4j;

/**
 * @Project: demo
 * @Package: com.cafe.pattern.state.order.status
 * @Author: zhouboyi
 * @Date: 2024/11/14 16:49
 * @Description: 6: 已收货
 */
@Slf4j
public class Received extends OrderStatus {

    protected Received() {

    }

    @Override
    public void confirm(Order order) {
        log.info("order [{}] has been received, do not repeat confirm!", order.getId());
    }

    @Override
    public void pay(Order order) {
        log.info("order [{}] has been received, do not repeat pay!", order.getId());
    }

    @Override
    public void ship(Order order) {
        log.info("order [{}] has been received, do not repeat ship!", order.getId());
    }

    @Override
    public void delivery(Order order) {
        log.info("order [{}] has been received, do not repeat delivery!", order.getId());
    }

    @Override
    public void receive(Order order) {
        log.info("order [{}] has been received, do not repeat receive!", order.getId());
    }

    @Override
    public void cancel(Order order) {
        log.info("order [{}] has been received, can not cancel!", order.getId());
    }
}
