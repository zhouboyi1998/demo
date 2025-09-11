package com.cafe.concurrent.loop100;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @Project: demo
 * @Package: com.cafe.concurrent.loop100
 * @Author: zhouboyi
 * @Date: 2024/12/16 18:03
 * @Description: 轮流打印数字 (CyclicBarrier)
 */
public class LoopPrintNumberTask3 implements Runnable {

    /**
     * 循环栅栏 (控制线程同步)
     */
    private static CyclicBarrier BARRIER = null;

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
    public LoopPrintNumberTask3() {
        this.id = ++THREAD_COUNT;
    }

    /**
     * 重置默认值
     */
    public static void resetDefault() {
        BARRIER = null;
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
     * 初始化循环栅栏
     */
    public static void initCyclicBarrier() {
        BARRIER = new CyclicBarrier(THREAD_COUNT, () -> FINISHED = ++CUR_NUM > MAX_NUM);
    }

    /**
     * 线程运行逻辑
     */
    @Override
    public void run() {
        while (!FINISHED) {
            if (BARRIER == null) {
                continue;
            }
            if (id % THREAD_COUNT == CUR_NUM % THREAD_COUNT) {
                System.out.println(Thread.currentThread().getName() + ":\t" + CUR_NUM);
            }
            try {
                BARRIER.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }
}
