package com.cafe.pattern.chainofresponsibility.order.checker;

import com.cafe.pattern.chainofresponsibility.order.Order;

import java.util.Objects;

/**
 * @Project: demo
 * @Package: com.cafe.pattern.chainofresponsibility.order.checker
 * @Author: zhouboyi
 * @Date: 2025/9/15 11:53
 * @Description: 购买商品校验器
 */
public class GoodsChecker extends AbstractOrderChecker {

    @Override
    public boolean check(Order order) {
        // 模拟校验购买商品是否存在
        if (order.getGoodsId() < 1) {
            return false;
        }
        // 模拟校验购买商品数量是否合法、是否充足
        if (order.getCount() < 1 || order.getCount() > 100) {
            return false;
        }
        System.out.println("购买商品校验通过");
        return Objects.isNull(getNext()) || getNext().check(order);
    }
}
