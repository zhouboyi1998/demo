package com.cafe.pattern.singleton.error;

import org.junit.jupiter.api.Test;

/**
 * @Project: demo
 * @Package: com.cafe.pattern.singleton.error
 * @Author: zhouboyi
 * @Date: 2024/8/11 16:20
 * @Description: {@link SingletonErrorCase1}
 */
public class SingletonErrorCase1Test {

    @Test
    void test() throws InterruptedException {
        // 创建线程
        Thread thread1 = new Thread(new SingletonErrorCase1Thread(), "Thread-1");
        Thread thread2 = new Thread(new SingletonErrorCase1Thread(), "Thread-2");

        // 启动线程
        thread1.start();
        thread2.start();

        // 等待线程执行完毕
        thread1.join();
        thread2.join();
    }
}
