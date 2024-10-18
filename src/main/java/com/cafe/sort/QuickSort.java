package com.cafe.sort;

/**
 * @Project: demo
 * @Package: com.cafe.sort
 * @Author: zhouboyi
 * @Date: 2024/10/17 21:13
 * @Description: 快速排序
 */
public class QuickSort implements Sort {

    @Override
    public void sort(int[] array) {
        sort(array, 0, array.length - 1);
    }

    private void sort(int[] array, int start, int end) {
        // 使用左右指针遍历当前数组
        int left = start;
        int right = end;

        // 以当前数组的第一个元素为 key
        int key = array[start];

        while (right > left) {
            // right 指针从后往前遍历
            // 如果当前元素比 key 大, 比较下一个
            // 如果当前元素比 key 小, 交换两者的位置
            while (right > left && array[right] >= key) {
                right--;
            }
            if (array[right] <= key) {
                int temp = array[right];
                array[right] = array[left];
                array[left] = temp;
            }

            // left 指针从前往后遍历
            // 如果当前元素比 key 小, 比较下一个
            // 如果当前元素比 key 大, 交换两者的位置
            while (right > left && array[left] <= key) {
                left++;
            }
            if (array[left] >= key) {
                int temp = array[left];
                array[left] = array[right];
                array[right] = temp;
            }

            // 一轮循环比较结束后, 当前 key 的位置已经确定
            // key 左边的元素, 都比 key 小
            // key 右边的元素, 都比 key 大
            // 但是 key 左右的两个子数组, 还是未排序的状态
        }

        // 递归排序当前 key 左右的两个子数组
        // 对当前 key 的左子数组进行排序
        if (left > start) {
            sort(array, start, left - 1);
        }

        // 对当前 key 的右子数组进行排序
        if (right < end) {
            sort(array, right + 1, end);
        }
    }
}
