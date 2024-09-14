package com.cafe.pattern.singleton;

/**
 * @Project: demo
 * @Package: com.cafe.pattern.singleton
 * @Author: zhouboyi
 * @Date: 2024/9/14 23:29
 * @Description: 单例模式 (懒汉式, 静态内部类)
 */
public class Singleton4 {

    private Singleton4() {
    }

    public static Singleton4 getInstance() {
        return Singleton4Holder.INSTANCE;
    }

    private static class Singleton4Holder {
        // 利用 JVM 类加载的一些机制, 来保证单例模式创建时的线程安全
        // 机制 1: 静态内部类只有在第一次被访问时, 才会被 JVM 加载
        // 机制 2: JVM 在加载类时, 会保证线程安全, 防止一个类被加载多次, 出现多个该类的 Class 实例
        private static final Singleton4 INSTANCE = new Singleton4();
    }
}
