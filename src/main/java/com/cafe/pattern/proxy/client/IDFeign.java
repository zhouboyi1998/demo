package com.cafe.pattern.proxy.client;

/**
 * @Project: demo
 * @Package: com.cafe.pattern.proxy.client
 * @Author: zhouboyi
 * @Date: 2024/11/21 17:40
 * @Description: ID 远程方法调用接口
 */
public interface IDFeign {

    /**
     * 获取下一个 ID
     *
     * @return ID
     */
    Long nextId();
}
