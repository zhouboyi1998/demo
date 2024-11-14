package com.cafe.pattern.state.order.status;

import com.cafe.pattern.state.order.Order;
import lombok.extern.slf4j.Slf4j;

/**
 * @Project: demo
 * @Package: com.cafe.pattern.state.order.status
 * @Author: zhouboyi
 * @Date: 2024/11/14 16:46
 * @Description: 3: 已支付 / 待发货
 */
@Slf4j
public class Paid extends OrderStatus {

    protected Paid() {

    }

    @Override
    public void confirm(Order order) {
        log.info("order [{}] has been paid, do not repeat confirm!", order.getId());
    }

    @Override
    public void pay(Order order) {
        log.info("order [{}] has been paid, do not repeat pay!", order.getId());
    }

    @Override
    public void ship(Order order) {
        order.setOrderStatus(new Shipped());
        log.info("order [{}] ship success!", order.getId());
    }

    @Override
    public void delivery(Order order) {
        log.info("order [{}] is not ship, can not be delivered!", order.getId());
    }

    @Override
    public void receive(Order order) {
        log.info("order [{}] is not ship, can not be received!", order.getId());
    }

    @Override
    public void cancel(Order order) {
        order.setOrderStatus(new Canceled());
        log.info("order [{}] cancel success, will be refunded after 24 hours!", order.getId());
    }
}
