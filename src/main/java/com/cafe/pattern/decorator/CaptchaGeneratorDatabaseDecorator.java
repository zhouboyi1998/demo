package com.cafe.pattern.decorator;

import lombok.extern.slf4j.Slf4j;

import java.util.UUID;

/**
 * @Project: demo
 * @Package: com.cafe.pattern.decorator
 * @Author: zhouboyi
 * @Date: 2024/11/21 16:23
 * @Description: Database 存储装饰器
 */
@Slf4j
public class CaptchaGeneratorDatabaseDecorator extends CaptchaGeneratorDecorator {

    /**
     * 验证码生成器（具体组件）
     */
    private final CaptchaGenerator generator;

    public CaptchaGeneratorDatabaseDecorator(CaptchaGenerator generator) {
        this.generator = generator;
    }

    @Override
    public Captcha generate() {
        // 使用验证码生成器生成验证码
        Captcha captcha = generator.generate();
        // 生成 Database ID
        String id = UUID.randomUUID().toString();
        // 模拟将验证码内容存入 Database 中
        log.info("insert [{}] captcha code into database, id: [{}], code: [{}]", generator.getClass().getSimpleName(), id, captcha.getCode());
        // 将 Database ID 存入验证码实体中
        return captcha.setKey(id);
    }
}
