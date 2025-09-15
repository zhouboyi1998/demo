package com.cafe.pattern.chainofresponsibility.order.checker;

import com.cafe.pattern.chainofresponsibility.order.Order;

/**
 * @Project: demo
 * @Package: com.cafe.pattern.chainofresponsibility.order.checker
 * @Author: zhouboyi
 * @Date: 2025/9/15 11:42
 * @Description: 订单校验器抽象类
 */
public abstract class AbstractOrderChecker implements IOrderChecker {

    private IOrderChecker next;

    public abstract boolean check(Order order);

    @Override
    public IOrderChecker getNext() {
        return this.next;
    }

    @Override
    public void setNext(IOrderChecker next) {
        this.next = next;
    }
}
