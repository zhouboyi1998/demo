package com.cafe.concurrent.thread.example1;

/**
 * @Project: demo
 * @Package: com.cafe.concurrent.thread.example1
 * @Author: zhouboyi
 * @Date: 2024/9/16 22:10
 * @Description: 循环打印数字的线程
 */
public class PrinterThread implements Runnable {

    /**
     * 锁对象 (用于控制线程同步)
     */
    private static final Object LOCK = new Object();

    private final int id;

    private static int curNum = 1;

    private final int maxNum;

    public PrinterThread(int id, int maxNum) {
        this.id = id;
        this.maxNum = maxNum;
    }

    @Override
    public void run() {
        while (curNum <= maxNum) {
            synchronized (LOCK) {
                while (id != curNum % 3) {
                    try {
                        LOCK.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (curNum <= maxNum) {
                    System.out.println(Thread.currentThread().getName() + ":\t" + curNum++);
                }
                LOCK.notifyAll();
            }
        }
    }
}
