package com.cafe.pattern.proxy.client;

import com.cafe.pattern.proxy.server.IDController;

/**
 * @Project: demo
 * @Package: com.cafe.pattern.proxy.client
 * @Author: zhouboyi
 * @Date: 2024/11/21 17:53
 * @Description: 模拟运行时动态代理生成的远程方法调用实现类
 */
public class IDFeignClient implements IDFeign {

    @Override
    public Long nextId() {
        // 模拟发起远程调用
        // 实际中 OpenFeign 是在这里发起了 HTTP 请求, 而不是普通的方法调用
        // http://{server_host}:{server_port}/id/next
        return new IDController().nextId();
    }
}
