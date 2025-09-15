package com.cafe.pattern.chainofresponsibility.order.checker;

import com.cafe.pattern.chainofresponsibility.order.Order;

import java.util.Objects;

/**
 * @Project: demo
 * @Package: com.cafe.pattern.chainofresponsibility.order.checker
 * @Author: zhouboyi
 * @Date: 2025/9/15 11:40
 * @Description: 重复订单校验器
 */
public class RepeatOrderChecker extends AbstractOrderChecker {

    @Override
    public boolean check(Order order) {
        // 模拟校验订单是否重复
        if (order.hashCode() == Integer.MIN_VALUE) {
            return false;
        }
        System.out.println("重复订单校验通过");
        return Objects.isNull(getNext()) || getNext().check(order);
    }
}
