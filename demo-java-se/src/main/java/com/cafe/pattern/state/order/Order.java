package com.cafe.pattern.state.order;

import com.cafe.pattern.state.order.status.Created;
import com.cafe.pattern.state.order.status.OrderStatus;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

/**
 * @Project: demo
 * @Package: com.cafe.pattern.state.order
 * @Author: zhouboyi
 * @Date: 2024/11/8 15:00
 * @Description: 订单
 */
@Getter
@Setter
public class Order {

    /**
     * 订单ID
     */
    private Long id;

    /**
     * 订单状态
     */
    private OrderStatus orderStatus;

    public Order() {
        this.id = (long) UUID.randomUUID().toString().hashCode();
        this.orderStatus = new Created(id);
    }

    /**
     * 确认
     */
    public void confirm() {
        orderStatus.confirm(this);
    }

    /**
     * 支付
     */
    public void pay() {
        orderStatus.pay(this);
    }

    /**
     * 发货
     */
    public void ship() {
        orderStatus.ship(this);
    }

    /**
     * 配送
     */
    public void delivery() {
        orderStatus.delivery(this);
    }

    /**
     * 收货
     */
    public void receive() {
        orderStatus.receive(this);
    }

    /**
     * 取消
     */
    public void cancel() {
        orderStatus.cancel(this);
    }
}
