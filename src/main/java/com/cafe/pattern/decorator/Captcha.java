package com.cafe.pattern.decorator;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Project: demo
 * @Package: com.cafe.pattern.decorator
 * @Author: zhouboyi
 * @Date: 2024/11/20 16:09
 * @Description: 验证码
 */
@Data
@Accessors(chain = true)
public class Captcha {

    /**
     * 验证码唯一标识
     */
    private String key;

    /**
     * 验证码内容
     */
    private String code;

    /**
     * Base64 格式验证码图片
     */
    private String image;
}
