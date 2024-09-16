package com.cafe.concurrent.thread.example1;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Project: demo
 * @Package: com.cafe.concurrent.thread.example1
 * @Author: zhouboyi
 * @Date: 2024/9/16 23:19
 * @Description: 三个线程轮流打印数字 (线程池版)
 */
public class LoopPrint2 {

    public static void main(String[] args) {
        // 创建线程池
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
            3, 3,
            0L, TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(10),
            r -> new Thread(r, "Thread-" + r.hashCode()),
            new ThreadPoolExecutor.AbortPolicy()
        );

        // 提交任务给线程池执行
        executor.execute(new PrinterThread(1, 100));
        executor.execute(new PrinterThread(2, 100));
        executor.execute(new PrinterThread(0, 100));
    }
}
