package com.cafe.pattern.proxy.server;

/**
 * @Project: demo
 * @Package: com.cafe.pattern.proxy.server
 * @Author: zhouboyi
 * @Date: 2024/11/21 17:35
 * @Description: ID 控制器
 * <p>
 * 根据代理模式的定义, 目标对象也需要实现抽象主题
 * 那么在这里, 为什么 IDController 不需要 implement IDFeign 呢
 * 因为实现不一定是 Java 中的 implement
 * IDFeign 动态代理生成的 IDFeignClient, 会通过 HTTP 请求服务端的 /id/next 路径
 * 而 IDController 可以处理 /id/next 路径请求的业务逻辑, 这也是一种实现
 */
// @RequestMapping(value = "/id")
public class IDController {

    private final Snowflake snowflake = new Snowflake(0, 0);

    // @GetMapping(value = "/next")
    public Long nextId() {
        return snowflake.nextId();
    }
}
