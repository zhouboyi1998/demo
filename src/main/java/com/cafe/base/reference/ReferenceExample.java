package com.cafe.base.reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
 * @Project: demo
 * @Package: com.cafe.base.reference
 * @Author: zhouboyi
 * @Date: 2024/9/24 16:25
 * @Description: Java 引用类型 (强引用、软引用、弱引用、虚引用)
 */
public class ReferenceExample {

    public static void main(String[] args) {
        // 强引用
        Object strongReference = new Object();

        // 软引用
        SoftReference<Object> softReference = new SoftReference<>(new Object());

        // 弱引用
        WeakReference<Object> weakReference = new WeakReference<>(new Object());

        // 虚引用 (需要放入一个引用队列中)
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
        PhantomReference<Object> phantomReference = new PhantomReference<>(new Object(), referenceQueue);

        // 打印 4 种引用类型的对象
        System.out.println("Strong Reference: " + strongReference);
        System.out.println("Soft Reference: " + softReference.get());
        System.out.println("Weak Reference: " + weakReference.get());
        // 无法通过虚引用获取对象, 所以 get() 方法的返回值是 null
        System.out.println("Phantom Reference: " + phantomReference.get());
    }
}
