package com.cafe.concurrent.loop100;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Semaphore;

/**
 * @Project: demo
 * @Package: com.cafe.concurrent.loop100
 * @Author: zhouboyi
 * @Date: 2024/12/17 10:39
 * @Description: 轮流打印数字 (Semaphore)
 */
public class LoopPrintNumberTask4 implements Runnable {

    /**
     * 信号量 (控制线程同步)
     */
    private static final Map<Integer, Semaphore> SEMAPHORE_MAP = new HashMap<>();

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
    public LoopPrintNumberTask4() {
        this.id = ++THREAD_COUNT;
        SEMAPHORE_MAP.put(id, new Semaphore(0));
    }

    /**
     * 重置默认值
     */
    public static void resetDefault() {
        SEMAPHORE_MAP.clear();
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
            while (id % THREAD_COUNT != CUR_NUM % THREAD_COUNT && !FINISHED) {
                try {
                    SEMAPHORE_MAP.get(id).acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (CUR_NUM <= MAX_NUM) {
                System.out.println(Thread.currentThread().getName() + ":\t" + CUR_NUM++);
            } else {
                FINISHED = true;
            }
            SEMAPHORE_MAP.get(id % THREAD_COUNT + 1).release();
        }
    }
}
