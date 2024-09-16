package com.cafe.base.singleton.error.case1;

/**
 * @Project: demo
 * @Package: com.cafe.base.singleton.case1
 * @Author: zhouboyi
 * @Date: 2024/8/11 16:18
 * @Description: 错误示例: 单例模式 (懒汉式, 不加锁)
 */
public class SingletonErrorCase1 {

    private static SingletonErrorCase1 INSTANCE;

    private SingletonErrorCase1() {
    }

    public static SingletonErrorCase1 getInstance() {
        // 在这里打上断点, 并且选择线程模式
        if (INSTANCE == null) {
            // 让两个线程同时进入了 if 逻辑内部
            // 第一个线程 new 了一个实例, 第二个线程也 new 了一个实例
            // 后面创建的实例, 会覆盖前面创建的实例
            INSTANCE = new SingletonErrorCase1();
        }
        return INSTANCE;
    }
}
