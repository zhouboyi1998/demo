package com.cafe.concurrent.loop100;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Project: demo
 * @Package: com.cafe.concurrent.loop100
 * @Author: zhouboyi
 * @Date: 2025/3/18 10:55
 * @Description: 轮流打印数字 (ReentrantReadWriteLock)
 */
public class LoopPrintNumberTask9 implements Runnable {

    /**
     * 可重入读写锁 (控制线程同步)
     */
    private static final ReentrantReadWriteLock LOCK = new ReentrantReadWriteLock();

    /**
     * 当前打印数字
     */
    private static int CUR_NUM = 1;

    /**
     * 最大打印数字
     */
    private static int MAX_NUM = 100;

    /**
     * 线程数量
     */
    private static int THREAD_COUNT = 0;

    /**
     * 线程 ID
     */
    private final int id;

    /**
     * 构造方法
     */
    public LoopPrintNumberTask9() {
        this.id = ++THREAD_COUNT;
    }

    /**
     * 重置默认值
     */
    public static void resetDefault() {
        CUR_NUM = 1;
        THREAD_COUNT = 0;
    }

    /**
     * 设置最大打印数字
     *
     * @param maxNum 最大打印数字
     */
    public static void setMaxNum(int maxNum) {
        MAX_NUM = maxNum;
    }

    /**
     * 线程运行逻辑
     */
    @Override
    public void run() {
        while (CUR_NUM <= MAX_NUM) {
            // 使用读写锁的写锁 (独占锁) 模式
            LOCK.writeLock().lock();
            if (id % THREAD_COUNT == CUR_NUM % THREAD_COUNT) {
                if (CUR_NUM <= MAX_NUM) {
                    System.out.println(Thread.currentThread().getName() + ":\t" + CUR_NUM++);
                }
            }
            LOCK.writeLock().unlock();
        }
    }
}
