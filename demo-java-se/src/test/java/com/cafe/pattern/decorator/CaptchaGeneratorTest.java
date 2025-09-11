package com.cafe.pattern.decorator;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * @Project: demo
 * @Package: com.cafe.pattern.decorator
 * @Author: zhouboyi
 * @Date: 2024/11/20 18:38
 * @Description: {@link CaptchaGenerator}
 */
@Slf4j
public class CaptchaGeneratorTest {

    /**
     * 使用 [彩色验证码生成器] 生成 [彩色验证码]
     */
    @Test
    void colorfulGenerator() {
        // 创建彩色验证码生成器
        CaptchaGenerator generator = new ColorfulCaptchaGenerator();
        // 生成验证码
        Captcha captcha = generator.generate();
        log.info("generate colorful captcha success, key: [{}], code: [{}], image: [{}]", captcha.getKey(), captcha.getCode(), captcha.getImage());
    }

    /**
     * 使用 [黑白验证码生成器] 生成 [黑白验证码]
     */
    @Test
    void grayGenerator() {
        // 创建黑白验证码生成器
        CaptchaGenerator generator = new GrayCaptchaGenerator();
        // 生成验证码
        Captcha captcha = generator.generate();
        log.info("generate gray captcha success, key: [{}], code: [{}], image: [{}]", captcha.getKey(), captcha.getCode(), captcha.getImage());
    }

    /**
     * 使用 [Redis 存储装饰器] 生成 [彩色验证码]
     */
    @Test
    void colorfulRedisDecorator() {
        // 创建彩色验证码生成器
        CaptchaGenerator generator = new ColorfulCaptchaGenerator();
        // 创建 Redis 存储装饰器
        CaptchaGenerator decorator = new CaptchaGeneratorRedisDecorator(generator);
        // 生成验证码
        Captcha captcha = decorator.generate();
        log.info("generate colorful captcha with redis decorator success, key: [{}], code: [{}], image: [{}]", captcha.getKey(), captcha.getCode(), captcha.getImage());
    }

    /**
     * 使用 [Redis 存储装饰器] 生成 [黑白验证码]
     */
    @Test
    void grayRedisDecorator() {
        // 创建黑白验证码生成器
        CaptchaGenerator generator = new GrayCaptchaGenerator();
        // 创建 Redis 存储装饰器
        CaptchaGenerator decorator = new CaptchaGeneratorRedisDecorator(generator);
        // 生成验证码
        Captcha captcha = decorator.generate();
        log.info("generate gray captcha with redis decorator success, key: [{}], code: [{}], image: [{}]", captcha.getKey(), captcha.getCode(), captcha.getImage());
    }

    /**
     * 使用 [Database 存储装饰器] 生成 [彩色验证码]
     */
    @Test
    void colorfulDatabaseDecorator() {
        // 创建彩色验证码生成器
        CaptchaGenerator generator = new ColorfulCaptchaGenerator();
        // 创建 Database 存储装饰器
        CaptchaGenerator decorator = new CaptchaGeneratorDatabaseDecorator(generator);
        // 生成验证码
        Captcha captcha = decorator.generate();
        log.info("generate colorful captcha with database decorator success, id: [{}], code: [{}], image: [{}]", captcha.getKey(), captcha.getCode(), captcha.getImage());
    }

    /**
     * 使用 [Database 存储装饰器] 生成 [黑白验证码]
     */
    @Test
    void grayDatabaseDecorator() {
        // 创建黑白验证码生成器
        CaptchaGenerator generator = new GrayCaptchaGenerator();
        // 创建 Database 存储装饰器
        CaptchaGenerator decorator = new CaptchaGeneratorDatabaseDecorator(generator);
        // 生成验证码
        Captcha captcha = decorator.generate();
        log.info("generate gray captcha with database decorator success, id: [{}], code: [{}], image: [{}]", captcha.getKey(), captcha.getCode(), captcha.getImage());
    }
}
