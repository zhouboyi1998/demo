package com.cafe.concurrent.loop100;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @Project: demo
 * @Package: com.cafe.concurrent.loop100
 * @Author: zhouboyi
 * @Date: 2024/12/17 14:45
 * @Description: 轮流打印数字 (LinkedBlockingQueue)
 */
public class LoopPrintNumberTask5 implements Runnable {

    /**
     * 阻塞队列 (控制线程同步)
     */
    private static final Map<Integer, LinkedBlockingQueue<Boolean>> QUEUE_MAP = new HashMap<>();

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
    public LoopPrintNumberTask5() {
        this.id = ++THREAD_COUNT;
        QUEUE_MAP.put(id, new LinkedBlockingQueue<>(1));
    }

    /**
     * 重置默认值
     */
    public static void resetDefault() {
        QUEUE_MAP.clear();
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
        while (!FINISHED) {
            try {
                if (id % THREAD_COUNT == CUR_NUM % THREAD_COUNT) {
                    System.out.println(Thread.currentThread().getName() + ":\t" + CUR_NUM++);
                    // 唤醒下一个线程
                    QUEUE_MAP.get(id % THREAD_COUNT + 1).put(true);
                }
                if (CUR_NUM <= MAX_NUM) {
                    // 阻塞, 直到自己对应的阻塞队列中被存入元素
                    QUEUE_MAP.get(id).take();
                } else {
                    FINISHED = true;
                    // 唤醒所有线程, 防止打印结束后线程被无限期阻塞
                    QUEUE_MAP.values().forEach(queue -> {
                        try {
                            queue.put(true);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    });
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
