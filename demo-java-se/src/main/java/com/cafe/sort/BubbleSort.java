package com.cafe.sort;

/**
 * @Project: demo
 * @Package: com.cafe.sort
 * @Author: zhouboyi
 * @Date: 2024/10/17 18:00
 * @Description: 冒泡排序
 */
public class BubbleSort implements Sort {

    @Override
    public void sort(int[] array) {
        int length = array.length;
        for (int i = 0; i < length - 1; i++) {
            // 标记本轮遍历中, 是否发生过交换
            boolean swap = false;
            for (int j = 0; j < length - 1 - i; j++) {
                // 如果前一个元素大于后一个元素, 交换两个元素的位置
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swap = true;
                }
            }
            // 如果在本轮遍历中, 没有发生过任何交换, 说明数组已经排序完成
            if (!swap) {
                break;
            }
        }
    }
}
