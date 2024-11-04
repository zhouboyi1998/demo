package com.cafe.pattern.strategy;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.ServiceLoader;

/**
 * @Project: demo
 * @Package: com.cafe.pattern.strategy
 * @Author: zhouboyi
 * @Date: 2024/11/04 14:46
 * @Description: 支付上下文
 */
public class PayContext {

    private final Map<String, PayService> payServiceMap = new HashMap<>();

    public PayContext() {
        // 在实际开发中, 如果使用的是 Spring 框架
        // 可以使用 List 注入的方式, 将所有支付服务注入进来
        // 再通过 @PostConstruct 注解, 遍历 payServiceList, 组装成 payServiceMap
        ServiceLoader<PayService> payServiceLoader = ServiceLoader.load(PayService.class);
        payServiceLoader.forEach(payService -> payServiceMap.put(payService.getClass().getSimpleName(), payService));
    }

    public PayService getPayService(String name) {
        return Optional.ofNullable(name)
            .map(payServiceMap::get)
            .orElseThrow(() -> new IllegalArgumentException("No such pay service! name: [" + name + "]"));
    }
}
