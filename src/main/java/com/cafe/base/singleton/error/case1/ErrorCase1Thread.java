package com.cafe.base.singleton.error.case1;

/**
 * @Project: demo
 * @Package: com.cafe.base.singleton.case1
 * @Author: zhouboyi
 * @Date: 2024/8/11 16:19
 * @Description: 测试线程
 */
public class ErrorCase1Thread implements Runnable {

    @Override
    public void run() {
        // 在这里打上断点, 并且选择线程模式
        SingletonErrorCase1 instance = SingletonErrorCase1.getInstance();
        System.out.println(Thread.currentThread().getName() + ":\t" + instance);
    }
}
