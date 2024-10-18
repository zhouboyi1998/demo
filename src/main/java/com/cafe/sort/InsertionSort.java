package com.cafe.sort;

/**
 * @Project: demo
 * @Package: com.cafe.sort
 * @Author: zhouboyi
 * @Date: 2024/10/18 16:06
 * @Description: 插入排序
 */
public class InsertionSort implements Sort {

    @Override
    public void sort(int[] array) {
        int length = array.length;
        for (int i = 0; i < length; i++) {
            for (int j = i; j > 0; j--) {
                if (array[j] < array[j - 1]) {
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
            }
        }
    }
}
