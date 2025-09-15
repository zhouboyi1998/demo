package com.cafe.pattern.chainofresponsibility.order.checker;

/**
 * @Project: demo
 * @Package: com.cafe.pattern.chainofresponsibility.order.checker
 * @Author: zhouboyi
 * @Date: 2025/9/15 14:45
 * @Description: 订单校验器管理器
 */
public class OrderCheckerManager {

    private final IOrderChecker orderChecker;

    public OrderCheckerManager() {
        RepeatOrderChecker repeatOrderChecker = new RepeatOrderChecker();
        UserChecker userChecker = new UserChecker();
        GoodsChecker goodsChecker = new GoodsChecker();
        AddressChecker addressChecker = new AddressChecker();

        repeatOrderChecker.setNext(userChecker);
        userChecker.setNext(goodsChecker);
        goodsChecker.setNext(addressChecker);

        this.orderChecker = repeatOrderChecker;
    }

    public IOrderChecker getOrderChecker() {
        return this.orderChecker;
    }
}
