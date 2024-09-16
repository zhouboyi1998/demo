package com.cafe.base.singleton.error.case1;

/**
 * @Project: demo
 * @Package: com.cafe.base.singleton.error.case1
 * @Author: zhouboyi
 * @Date: 2024/8/11 16:20
 * @Description: {@link SingletonErrorCase1}
 */
public class ErrorCase1Test {

    /**
     * 在 CaseThread、Singleton5 两个类中打上对应的断点, 然后运行
     * 在 IDEA debug 窗口右侧有个下拉框, 可以选择 Thread-1、Thread-2 两个线程
     * √ 表示当前选中的线程, ● 表示未被选中的线程
     * <p>
     * 通过这个错误示例
     * 可以知道懒加载的单例模式为什么需要加锁
     * 还可以了解多线程 debug 的基本流程
     */
    public static void main(String[] args) {
        Thread thread1 = new Thread(new ErrorCase1Thread(), "Thread-1");
        Thread thread2 = new Thread(new ErrorCase1Thread(), "Thread-2");

        thread1.start();
        thread2.start();
    }
}
