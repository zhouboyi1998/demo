package com.cafe.pattern.singleton;

/**
 * @Project: demo
 * @Package: com.cafe.pattern.singleton
 * @Author: zhouboyi
 * @Date: 2024/9/14 23:19
 * @Description: 单例模式 (懒汉式, 双重检验)
 */
public class Singleton3 {

    /**
     * INSTANCE = new Singleton3() 这条语句, 可能会被分解成多个指令:
     * 1. 分配内存空间
     * 2. 调用构造函数初始化对象
     * 3. 将对象引用赋值给 INSTANCE
     * <p>
     * 在没有 volatile 来保证 "有序性" 的情况下, 这些指令可能会被重排序:
     * 1. 分配内存空间
     * 2. 将对象引用赋值给 INSTANCE
     * 3. 调用构造函数初始化对象
     * <p>
     * 而在本例子中, synchronized 并没有锁住整个方法
     * 如果有多个线程同时进入 getInstance() 方法, 而语句被重排序的话
     * 可能会导致一些线程看到一个尚未完全初始化的 INSTANCE 对象:
     * 1. 线程 A 执行了重排序后的 1、2 两条指令, 但尚未执行第 3 条指令
     * 2. 此时线程 B 进入 getInstance() 方法, 会看到 INSTANCE != null, 然后直接获取 INSTANCE 对象
     * 然而此时的 INSTANCE 对象尚未完全初始化, 这个对象并不可用, 导致线程 B 后续的代码执行错误
     * <p>
     * 所以, 使用双重检验的方式, 需要给 INSTANCE 对象添加 volatile 修饰符
     */
    private static volatile Singleton3 INSTANCE;

    private Singleton3() {
    }

    public static Singleton3 getInstance() {
        // 使用双重检验的方式, 进行两次 null 检验
        // 且在第二次检验时才加锁
        if (INSTANCE == null) {
            // 虽然在第二次检验时, 会锁住整个类
            // 但是只有在单例对象还未创建的时候
            // 线程才会通过第一次 null 检验, 走到第二次 null 检验的逻辑这里
            // 此时线程才会被锁住
            synchronized (Singleton3.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Singleton3();
                }
            }
        }
        // 如果单例对象已经被创建了
        // 那么后续的线程, 连第一次 null 检验都不会通过, 第一个 if 内部都不会进入, 也就不会被锁住了
        // 所以, 双重检验, 即确保了创建时的线程安全, 又保证了后续的并发性
        return INSTANCE;
    }
}
