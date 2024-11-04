package com.cafe.pattern.singleton;

import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Project: demo
 * @Package: com.cafe.pattern.singleton
 * @Author: zhouboyi
 * @Date: 2024/9/15 2:02
 * @Description: {@link Singleton1}
 */
public class Singleton1Test {

    private static final Random RANDOM = new Random();

    @Test
    void test() {
        // 创建一个线程数为 10 的线程池
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
            10, 10,
            0, TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(10),
            r -> new Thread(r, "Thread-" + RANDOM.nextInt(100)),
            new ThreadPoolExecutor.AbortPolicy()
        );
        // 提交 10 个任务给线程池
        for (int i = 0; i < 10; i++) {
            // 每个任务都是打印线程名称和单例对象
            executor.submit(() ->
                System.out.println(Thread.currentThread().getName() + ":\t" + Singleton1.getInstance()));
        }
        // 等待所有任务执行完成, 关闭线程池
        executor.shutdown();
    }
}
