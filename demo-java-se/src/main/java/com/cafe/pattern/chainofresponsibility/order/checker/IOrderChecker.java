package com.cafe.pattern.chainofresponsibility.order.checker;

import com.cafe.pattern.chainofresponsibility.order.Order;

/**
 * @Project: demo
 * @Package: com.cafe.pattern.chainofresponsibility.order.checker
 * @Author: zhouboyi
 * @Date: 2025/9/15 11:30
 * @Description: 订单校验器接口
 */
public interface IOrderChecker {

    /**
     * 校验订单
     *
     * @param order 订单
     * @return 是否通过
     */
    boolean check(Order order);

    /**
     * 获取下一个校验器
     *
     * @return 下一个校验器
     */
    IOrderChecker getNext();

    /**
     * 设置下一个校验器
     *
     * @param next 下一个校验器
     */
    void setNext(IOrderChecker next);
}
