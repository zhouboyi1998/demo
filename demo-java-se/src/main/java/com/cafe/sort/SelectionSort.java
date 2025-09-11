package com.cafe.sort;

/**
 * @Project: demo
 * @Package: com.cafe.sort
 * @Author: zhouboyi
 * @Date: 2024/10/18 16:16
 * @Description: 选择排序
 */
public class SelectionSort implements Sort {

    @Override
    public void sort(int[] array) {
        int length = array.length;
        for (int i = 0; i < length - 1; i++) {
            // 存储本轮遍历中, 最小元素的索引
            int min = i;
            for (int j = i + 1; j < length; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            if (min != i) {
                int temp = array[i];
                array[i] = array[min];
                array[min] = temp;
            }
        }
    }
}
