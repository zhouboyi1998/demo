package com.cafe.pattern.chainofresponsibility.order;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Project: demo
 * @Package: com.cafe.pattern.chainofresponsibility.order
 * @Author: zhouboyi
 * @Date: 2025/9/15 11:31
 * @Description: 订单
 */
@Data
@Accessors(chain = true)
public class Order {

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 商品ID
     */
    private Long goodsId;

    /**
     * 下单数量
     */
    private Integer count;

    /**
     * 收货地址ID
     */
    private Long addressId;
}
