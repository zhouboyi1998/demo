package com.cafe.concurrent.thread.example1;

/**
 * @Project: demo
 * @Package: com.cafe.concurrent.thread.example1
 * @Author: zhouboyi
 * @Date: 2024/9/15 2:27
 * @Description: 三个线程轮流打印数字
 */
public class LoopPrint1 {

    public static void main(String[] args) {
        // 创建线程
        Thread thread1 = new Thread(new PrinterThread(1, 100), "Thread-1");
        Thread thread2 = new Thread(new PrinterThread(2, 100), "Thread-2");
        Thread thread3 = new Thread(new PrinterThread(0, 100), "Thread-3");

        // 启动线程
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
