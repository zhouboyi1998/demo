package com.cafe.pattern.state.order.status;

import com.cafe.pattern.state.order.Order;
import lombok.extern.slf4j.Slf4j;

/**
 * @Project: demo
 * @Package: com.cafe.pattern.state.order.status
 * @Author: zhouboyi
 * @Date: 2024/11/14 18:00
 * @Description: -1: 已取消
 */
@Slf4j
public class Canceled extends OrderStatus {

    protected Canceled() {

    }

    @Override
    public void confirm(Order order) {
        log.info("order [{}] has been canceled, can not confirm!", order.getId());
    }

    @Override
    public void pay(Order order) {
        log.info("order [{}] has been canceled, can not pay!", order.getId());
    }

    @Override
    public void ship(Order order) {
        log.info("order [{}] has been canceled, can not ship!", order.getId());
    }

    @Override
    public void delivery(Order order) {
        log.info("order [{}] has been canceled, can not delivery!", order.getId());
    }

    @Override
    public void receive(Order order) {
        log.info("order [{}] has been canceled, can not receive!", order.getId());
    }

    @Override
    public void cancel(Order order) {
        log.info("order [{}] has been canceled, do not repeat cancel!", order.getId());
    }
}
