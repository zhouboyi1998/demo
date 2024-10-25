package com.cafe.concurrent.thread.loop;

/**
 * @Project: demo
 * @Package: com.cafe.concurrent.thread.loop
 * @Author: zhouboyi
 * @Date: 2024/9/16 22:10
 * @Description: 轮流打印数字 (synchronized)
 */
public class LoopPrintTask1 implements Runnable {

    /**
     * 锁对象 (控制线程同步)
     */
    private static final Object LOCK = new Object();

    /**
     * 标记打印是否已经结束
     */
    public static volatile boolean finished = false;

    private final int id;

    public static int curNum = 1;

    private final int maxNum;

    public LoopPrintTask1(int id, int maxNum) {
        this.id = id;
        this.maxNum = maxNum;
    }

    @Override
    public void run() {
        while (curNum <= maxNum) {
            synchronized (LOCK) {
                while (id != curNum % 3 && !finished) {
                    try {
                        LOCK.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (curNum <= maxNum) {
                    System.out.println(Thread.currentThread().getName() + ":\t" + curNum++);
                } else {
                    finished = true;
                }
                LOCK.notifyAll();
            }
        }
    }
}
