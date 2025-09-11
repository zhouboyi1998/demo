package com.cafe.pattern.singleton;

/**
 * @Project: demo
 * @Package: com.cafe.pattern.singleton
 * @Author: zhouboyi
 * @Date: 2024/9/14 22:42
 * @Description: 单例模式 (饿汉式)
 */
public class Singleton1 {

    private static final Singleton1 INSTANCE = new Singleton1();

    private Singleton1() {
    }

    public static Singleton1 getInstance() {
        return INSTANCE;
    }
}
