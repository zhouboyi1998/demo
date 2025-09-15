package com.cafe.pattern.chainofresponsibility.order;

import com.cafe.pattern.chainofresponsibility.order.checker.OrderCheckerManager;

/**
 * @Project: demo
 * @Package: com.cafe.pattern.chainofresponsibility.order
 * @Author: zhouboyi
 * @Date: 2025/9/15 11:59
 * @Description: 客户端
 */
public class Client {

    private final OrderCheckerManager orderCheckerManager;

    public Client() {
        orderCheckerManager = new OrderCheckerManager();
    }

    public boolean checkOrder(Order order) {
        return orderCheckerManager.getOrderChecker().check(order);
    }
}
