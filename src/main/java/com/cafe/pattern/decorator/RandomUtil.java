package com.cafe.pattern.decorator;

import java.util.Random;

/**
 * @Project: demo
 * @Package: com.cafe.pattern.decorator
 * @Author: zhouboyi
 * @Date: 2024/11/20 16:47
 * @Description: 随机工具类
 */
public class RandomUtil {

    private static final Random RANDOM = new Random();

    /**
     * 生成随机数字
     *
     * @return 生成的随机数字 [0-9]
     */
    public static int randomDigit() {
        return RANDOM.nextInt(10);
    }

    /**
     * 生成随机小写字母
     *
     * @return 生成的小写字母 [a-z]
     */
    public static char randomLower() {
        return (char) (RANDOM.nextInt(26) + 'a');
    }

    /**
     * 生成随机大写字母
     *
     * @return 生成的大写字母 [A-Z]
     */
    public static char randomUpper() {
        return (char) (RANDOM.nextInt(26) + 'A');
    }

    /**
     * 生成随机字符串
     *
     * @param length 字符串长度
     * @return 生成的字符串
     */
    public static String randomString(int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int route = RANDOM.nextInt(3);
            if (route == 0) {
                sb.append(randomDigit());
            } else if (route == 1) {
                sb.append(randomLower());
            } else {
                sb.append(randomUpper());
            }
        }
        return sb.toString();
    }
}
