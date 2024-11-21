package com.cafe.pattern.decorator;

/**
 * @Project: demo
 * @Package: com.cafe.pattern.decorator
 * @Author: zhouboyi
 * @Date: 2024/11/20 16:03
 * @Description: 验证码生成器
 */
public interface CaptchaGenerator {

    /**
     * 生成验证码
     *
     * @return 验证码
     */
    Captcha generate();
}
