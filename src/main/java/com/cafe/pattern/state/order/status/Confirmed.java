package com.cafe.pattern.state.order.status;

import com.cafe.pattern.state.order.Order;
import lombok.extern.slf4j.Slf4j;

/**
 * @Project: demo
 * @Package: com.cafe.pattern.state.order.status
 * @Author: zhouboyi
 * @Date: 2024/11/14 16:43
 * @Description: 2: 已确认 / 待支付
 */
@Slf4j
public class Confirmed extends OrderStatus {

    protected Confirmed() {

    }

    @Override
    public void confirm(Order order) {
        log.info("order [{}] has been confirmed, do not repeat confirm!", order.getId());
    }

    @Override
    public void pay(Order order) {
        order.setOrderStatus(new Paid());
        log.info("order [{}] pay success!", order.getId());
    }

    @Override
    public void ship(Order order) {
        log.info("order [{}] is not pay, can not be shipped!", order.getId());
    }

    @Override
    public void delivery(Order order) {
        log.info("order [{}] is not pay, can not be delivered!", order.getId());
    }

    @Override
    public void receive(Order order) {
        log.info("order [{}] is not pay, can not be received!", order.getId());
    }

    @Override
    public void cancel(Order order) {
        order.setOrderStatus(new Canceled());
        log.info("order [{}] cancel success!", order.getId());
    }
}
