package com.cafe.pattern.decorator;

/**
 * @Project: demo
 * @Package: com.cafe.pattern.decorator
 * @Author: zhouboyi
 * @Date: 2024/11/20 16:08
 * @Description: 黑白验证码生成器
 */
public class GrayCaptchaGenerator implements CaptchaGenerator {

    @Override
    public Captcha generate() {
        // 生成验证码内容
        String code = RandomUtil.randomString(4);
        // 模拟生成黑白验证码图片
        String image = "data:$jpg;base64,gray";
        // 返回验证码实体
        return new Captcha().setCode(code).setImage(image);
    }
}
