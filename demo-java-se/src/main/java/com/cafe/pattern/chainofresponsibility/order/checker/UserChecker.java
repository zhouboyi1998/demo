package com.cafe.pattern.chainofresponsibility.order.checker;

import com.cafe.pattern.chainofresponsibility.order.Order;

import java.util.Objects;

/**
 * @Project: demo
 * @Package: com.cafe.pattern.chainofresponsibility.order.checker
 * @Author: zhouboyi
 * @Date: 2025/9/15 11:49
 * @Description: 下单用户校验器
 */
public class UserChecker extends AbstractOrderChecker {

    @Override
    public boolean check(Order order) {
        // 模拟校验下单用户是否合法
        if (order.getUserId() < 1) {
            return false;
        }
        System.out.println("下单用户校验通过");
        return Objects.isNull(getNext()) || getNext().check(order);
    }
}
