package com.cafe.pattern.proxy.client;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * @Project: demo
 * @Package: com.cafe.pattern.proxy.client
 * @Author: zhouboyi
 * @Date: 2024/11/21 20:01
 * @Description: {@link IDFeign}
 */
public class IDFeignTest {

    private static IDFeign idFeign;

    @BeforeAll
    static void setUp() {
        idFeign = new IDFeignClient();
    }

    @Test
    void nextId() {
        System.out.println(idFeign.nextId());
    }
}
