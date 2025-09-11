package com.cafe.pattern.decorator;

/**
 * @Project: demo
 * @Package: com.cafe.pattern.decorator
 * @Author: zhouboyi
 * @Date: 2024/11/21 16:17
 * @Description: 抽象装饰器
 */
public abstract class CaptchaGeneratorDecorator implements CaptchaGenerator {

    @Override
    public abstract Captcha generate();
}
