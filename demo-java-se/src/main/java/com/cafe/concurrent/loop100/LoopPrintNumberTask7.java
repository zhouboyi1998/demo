package com.cafe.concurrent.loop100;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.LockSupport;

/**
 * @Project: demo
 * @Package: com.cafe.concurrent.loop100
 * @Author: zhouboyi
 * @Date: 2024/12/18 0:24
 * @Description: 轮流打印数字 (LockSupport)
 */
public class LoopPrintNumberTask7 extends Thread {

    /**
     * 线程集合
     */
    private static final Map<Integer, Thread> THREAD_MAP = new HashMap<>();

    /**
     * 标记打印是否可以开始
     */
    private static boolean STARTED = false;

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
    public LoopPrintNumberTask7() {
        this.id = ++THREAD_COUNT;
    }

    /**
     * 重置默认值
     */
    public static void resetDefault() {
        THREAD_MAP.clear();
        STARTED = false;
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
     * 打印开始
     */
    public static void printStart() {
        STARTED = true;
    }

    /**
     * 线程运行逻辑
     */
    @Override
    public void run() {
        // 在运行时, 将实际运行的线程对象放入线程集合中
        THREAD_MAP.put(id, Thread.currentThread());
        while (!FINISHED) {
            if (!STARTED) {
                continue;
            }
            while (id % THREAD_COUNT != CUR_NUM % THREAD_COUNT && !FINISHED) {
                // 阻塞当前线程
                LockSupport.park();
            }
            if (CUR_NUM <= MAX_NUM) {
                System.out.println(Thread.currentThread().getName() + ":\t" + CUR_NUM++);
            } else {
                FINISHED = true;
            }
            // 唤醒下一个线程
            LockSupport.unpark(THREAD_MAP.get(id % THREAD_COUNT + 1));
        }
    }
}
