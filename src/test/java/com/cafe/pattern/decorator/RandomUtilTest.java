package com.cafe.pattern.decorator;

import org.junit.jupiter.api.Test;

/**
 * @Project: demo
 * @Package: com.cafe.pattern.decorator
 * @Author: zhouboyi
 * @Date: 2024/11/20 17:06
 * @Description: {@link RandomUtil}
 */
public class RandomUtilTest {

    @Test
    void randomDigit() {
        System.out.println(RandomUtil.randomDigit());
    }

    @Test
    void randomLower() {
        System.out.println(RandomUtil.randomLower());
    }

    @Test
    void randomUpper() {
        System.out.println(RandomUtil.randomUpper());
    }

    @Test
    void randomString() {
        System.out.println(RandomUtil.randomString(4));
    }
}
