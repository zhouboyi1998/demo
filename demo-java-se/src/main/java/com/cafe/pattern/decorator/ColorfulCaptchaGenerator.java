package com.cafe.pattern.decorator;

/**
 * @Project: demo
 * @Package: com.cafe.pattern.decorator
 * @Author: zhouboyi
 * @Date: 2024/11/20 16:07
 * @Description: 彩色验证码生成器
 */
public class ColorfulCaptchaGenerator implements CaptchaGenerator {

    @Override
    public Captcha generate() {
        // 生成验证码内容
        String code = RandomUtil.randomString(4);
        // 模拟生成彩色验证码图片
        String image = "data:$jpg;base64,colorful";
        // 返回验证码实体
        return new Captcha().setCode(code).setImage(image);
    }
}
