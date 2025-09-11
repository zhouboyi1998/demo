package com.cafe.pattern.singleton;

/**
 * @Project: demo
 * @Package: com.cafe.pattern.singleton
 * @Author: zhouboyi
 * @Date: 2024/9/14 23:14
 * @Description: 单例模式 (懒汉式)
 */
public class Singleton2 {

    private static Singleton2 INSTANCE;

    private Singleton2() {
    }

    public static synchronized Singleton2 getInstance() {
        // 使用 synchronized 锁住整个方法, 并发度极低
        if (INSTANCE == null) {
            INSTANCE = new Singleton2();
        }
        return INSTANCE;
    }
}
