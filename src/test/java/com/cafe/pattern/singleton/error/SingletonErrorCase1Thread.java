package com.cafe.pattern.singleton.error;

/**
 * @Project: demo
 * @Package: com.cafe.pattern.singleton.error
 * @Author: zhouboyi
 * @Date: 2024/8/11 16:19
 * @Description: 单例模式错误示例测试线程
 */
public class SingletonErrorCase1Thread implements Runnable {

    @Override
    public void run() {
        SingletonErrorCase1 instance = SingletonErrorCase1.getInstance();
        // 打上断点, 可以观察到: 两个线程持有的 instance 对象, 不是同一个
        // 控制台输出, 也可以观察到: 两个线程输出的 instance 对象, 不是同一个
        System.out.println(Thread.currentThread().getName() + ":\t" + instance);
    }
}
