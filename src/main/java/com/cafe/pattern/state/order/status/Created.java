package com.cafe.pattern.state.order.status;

import com.cafe.pattern.state.order.Order;
import lombok.extern.slf4j.Slf4j;

/**
 * @Project: demo
 * @Package: com.cafe.pattern.state.order.status
 * @Author: zhouboyi
 * @Date: 2024/11/14 16:43
 * @Description: 1: 已生成 / 待确认
 */
@Slf4j
public class Created extends OrderStatus {

    public Created(Long id) {
        log.info("order [{}] create success!", id);
    }

    @Override
    public void confirm(Order order) {
        order.setOrderStatus(new Confirmed());
        log.info("order [{}] confirm success!", order.getId());
    }

    @Override
    public void pay(Order order) {
        log.info("order [{}] is not confirm, can not be paid!", order.getId());
    }

    @Override
    public void ship(Order order) {
        log.info("order [{}] is not confirm, can not be shipped!", order.getId());
    }

    @Override
    public void delivery(Order order) {
        log.info("order [{}] is not confirm, can not be delivered!", order.getId());
    }

    @Override
    public void receive(Order order) {
        log.info("order [{}] is not confirm, can not be received!", order.getId());
    }

    @Override
    public void cancel(Order order) {
        order.setOrderStatus(new Canceled());
        log.info("order [{}] cancel success!", order.getId());
    }
}
