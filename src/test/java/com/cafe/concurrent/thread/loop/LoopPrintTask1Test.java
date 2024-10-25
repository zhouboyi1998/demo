package com.cafe.concurrent.thread.loop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Project: demo
 * @Package: com.cafe.concurrent.thread.loop
 * @Author: zhouboyi
 * @Date: 2024/10/25 16:48
 * @Description: {@link LoopPrintTask1}
 */
public class LoopPrintTask1Test {

    @BeforeEach
    void beforeEach() {
        LoopPrintTask1.finished = false;
        LoopPrintTask1.curNum = 1;
    }

    /**
     * 三个线程轮流打印数字
     */
    @Test
    void testWithThread() throws InterruptedException {
        // 创建线程
        Thread thread1 = new Thread(new LoopPrintTask1(1, 100), "Thread-1");
        Thread thread2 = new Thread(new LoopPrintTask1(2, 100), "Thread-2");
        Thread thread3 = new Thread(new LoopPrintTask1(0, 100), "Thread-3");

        // 启动线程
        thread1.start();
        thread2.start();
        thread3.start();

        // 等待线程执行完毕
        thread1.join();
        thread2.join();
        thread3.join();
    }

    /**
     * 线程池中的三个线程轮流打印数字
     */
    @Test
    void testWithThreadPool() throws InterruptedException {
        // 创建线程池
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
            3, 3,
            0L, TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(10),
            r -> new Thread(r, "Thread-" + r.hashCode()),
            new ThreadPoolExecutor.AbortPolicy()
        );

        // 提交任务给线程池执行
        executor.execute(new LoopPrintTask1(1, 100));
        executor.execute(new LoopPrintTask1(2, 100));
        executor.execute(new LoopPrintTask1(0, 100));

        // 关闭线程池
        executor.shutdown();

        // 等待线程池结束
        while (!executor.awaitTermination(1, TimeUnit.SECONDS)) {

        }
    }
}
