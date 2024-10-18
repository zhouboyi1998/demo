package com.cafe.sort;

/**
 * @Project: demo
 * @Package: com.cafe.sort
 * @Author: zhouboyi
 * @Date: 2024/10/18 14:53
 * @Description: 希尔排序
 */
public class ShellSort implements Sort {

    @Override
    public void sort(int[] array) {
        int length = array.length;
        for (int gap = length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < length; i++) {
                int temp = array[i];
                int j = i;
                for (; j >= gap && temp < array[j - gap]; j -= gap) {
                    array[j] = array[j - gap];
                }
                array[j] = temp;
            }
        }
    }
}
