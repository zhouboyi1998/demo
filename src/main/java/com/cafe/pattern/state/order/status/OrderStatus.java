package com.cafe.pattern.state.order.status;

import com.cafe.pattern.state.order.Order;
import lombok.extern.slf4j.Slf4j;

/**
 * @Project: demo
 * @Package: com.cafe.pattern.state.order.status
 * @Author: zhouboyi
 * @Date: 2024/11/8 14:29
 * @Description: 订单状态
 * 1: 已生成 / 待确认
 * 2: 已确认 / 待支付
 * 3: 已支付 / 待发货
 * 4: 已发货 / 待配送
 * 5: 已配送 / 待收货
 * 6: 已收货
 * -1: 已取消
 */
@Slf4j
public abstract class OrderStatus {

    /**
     * 确认 (1: 待确认 -> 2: 已确认)
     *
     * @param order 订单
     */
    public abstract void confirm(Order order);

    /**
     * 支付 (2: 待支付 -> 3: 已支付)
     *
     * @param order 订单
     */
    public abstract void pay(Order order);

    /**
     * 发货 (3: 待发货 -> 4: 已发货)
     *
     * @param order 订单
     */
    public abstract void ship(Order order);

    /**
     * 配送 (4: 待配送 -> 5: 已配送)
     *
     * @param order 订单
     */
    public abstract void delivery(Order order);

    /**
     * 收货 (5: 待收货 -> 6: 已收货)
     *
     * @param order 订单
     */
    public abstract void receive(Order order);

    /**
     * 取消 (* -> -1: 已取消)
     *
     * @param order 订单
     */
    public abstract void cancel(Order order);
}
