package com.cafe.concurrent.loop100;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

/**
 * @Project: demo
 * @Package: com.cafe.concurrent.loop100
 * @Author: zhouboyi
 * @Date: 2024/12/17 16:36
 * @Description: 轮流打印数字 (CountDownLatch)
 */
public class LoopPrintNumberTask6 implements Runnable {

    /**
     * 倒数闭锁 (控制线程同步)
     */
    private static final Map<Integer, CountDownLatch> LATCH_MAP = new ConcurrentHashMap<>();

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
    public LoopPrintNumberTask6() {
        this.id = ++THREAD_COUNT;
    }

    /**
     * 重置默认值
     */
    public static void resetDefault() {
        LATCH_MAP.clear();
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
     * 初始化倒数闭锁
     */
    public static void initCountDownLatch() {
        for (int i = 0; i < THREAD_COUNT; i++) {
            LATCH_MAP.put(i + 1, new CountDownLatch(i));
        }
    }

    /**
     * 线程运行逻辑
     */
    @Override
    public void run() {
        while (!FINISHED) {
            try {
                if (LATCH_MAP.isEmpty()) {
                    continue;
                }
                while (id % THREAD_COUNT != CUR_NUM % THREAD_COUNT && !FINISHED) {
                    LATCH_MAP.get(id).await();
                }
                if (CUR_NUM <= MAX_NUM) {
                    System.out.println(Thread.currentThread().getName() + ":\t" + CUR_NUM++);
                    // 重置自己对应的倒数闭锁
                    LATCH_MAP.remove(id);
                    LATCH_MAP.put(id, new CountDownLatch(THREAD_COUNT));
                } else {
                    FINISHED = true;
                }
                // 唤醒下一个线程
                LATCH_MAP.values().forEach(CountDownLatch::countDown);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
