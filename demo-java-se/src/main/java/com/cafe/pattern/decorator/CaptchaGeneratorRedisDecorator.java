package com.cafe.pattern.decorator;

import lombok.extern.slf4j.Slf4j;

import java.util.UUID;

/**
 * @Project: demo
 * @Package: com.cafe.pattern.decorator
 * @Author: zhouboyi
 * @Date: 2024/11/20 16:08
 * @Description: Redis 存储装饰器
 */
@Slf4j
public class CaptchaGeneratorRedisDecorator extends CaptchaGeneratorDecorator {

    /**
     * 验证码生成器（具体组件）
     */
    private final CaptchaGenerator generator;

    public CaptchaGeneratorRedisDecorator(CaptchaGenerator generator) {
        this.generator = generator;
    }

    @Override
    public Captcha generate() {
        // 使用验证码生成器生成验证码
        Captcha captcha = generator.generate();
        // 生成 Redis Key
        String key = UUID.randomUUID().toString();
        // 模拟将验证码内容存入 Redis 中
        log.info("insert [{}] captcha code into redis, key: [{}], code: [{}]", generator.getClass().getSimpleName(), key, captcha.getCode());
        // 将 Redis Key 存入验证码实体中
        return captcha.setKey(key);
    }
}
