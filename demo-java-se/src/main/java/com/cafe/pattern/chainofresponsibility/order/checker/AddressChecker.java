package com.cafe.pattern.chainofresponsibility.order.checker;

import com.cafe.pattern.chainofresponsibility.order.Order;

import java.util.Objects;

/**
 * @Project: demo
 * @Package: com.cafe.pattern.chainofresponsibility.order.checker
 * @Author: zhouboyi
 * @Date: 2025/9/15 11:55
 * @Description: 收货地址校验器
 */
public class AddressChecker extends AbstractOrderChecker {

    @Override
    public boolean check(Order order) {
        // 模拟校验收货地址是否合法
        if (order.getAddressId() < 1) {
            return false;
        }
        System.out.println("收货地址校验通过");
        return Objects.isNull(getNext()) || getNext().check(order);
    }
}
