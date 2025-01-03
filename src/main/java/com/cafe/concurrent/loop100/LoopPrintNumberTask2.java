package com.cafe.concurrent.loop100;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Project: demo
 * @Package: com.cafe.concurrent.loop100
 * @Author: zhouboyi
 * @Date: 2024/12/16 17:38
 * @Description: 轮流打印数字 (ReentrantLock)
 */
public class LoopPrintNumberTask2 implements Runnable {

    /**
     * 可重入锁 (控制线程同步)
     */
    private static final ReentrantLock LOCK = new ReentrantLock();

    /**
     * 条件变量 (控制线程等待和唤醒)
     */
    private static final Condition CONDITION = LOCK.newCondition();

    /**
     * 标记打印是否已经结束
     */
    private static volatile boolean FINISHED = false;

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
    public LoopPrintNumberTask2() {
        this.id = ++THREAD_COUNT;
    }

    /**
     * 重置默认值
     */
    public static void resetDefault() {
        FINISHED = false;
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
            LOCK.lock();
            try {
                while (id % THREAD_COUNT != CUR_NUM % THREAD_COUNT && !FINISHED) {
                    try {
                        CONDITION.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (CUR_NUM <= MAX_NUM) {
                    System.out.println(Thread.currentThread().getName() + ":\t" + CUR_NUM++);
                } else {
                    FINISHED = true;
                }
                CONDITION.signalAll();
            } finally {
                LOCK.unlock();
            }
        }
    }
}
