package com.cafe.sort;

/**
 * @Project: demo
 * @Package: com.cafe.sort
 * @Author: zhouboyi
 * @Date: 2024/10/17 22:47
 * @Description: 归并排序
 */
public class MergeSort implements Sort {

    @Override
    public void sort(int[] array) {
        sort(array, 0, array.length - 1);
    }

    private void sort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        // 获取中间索引
        int mid = left + (right - left) / 2;

        // 分别对左右子数组进行递归排序
        sort(array, left, mid);
        sort(array, mid + 1, right);

        // 合并已经完成排序的左右子数组
        merge(array, left, mid, right);
    }

    private void merge(int[] array, int left, int mid, int right) {
        // 使用临时数组存储排序结果
        int[] temp = new int[right - left + 1];

        int i = left;
        int j = mid + 1;
        int k = 0;

        // 遍历左右子数组, 比较两个子数组的元素, 将较小的元素放入临时数组中
        while (i <= mid && j <= right) {
            temp[k++] = array[i] <= array[j] ? array[i++] : array[j++];
        }

        // 如果左子数组还有剩余元素, 将左子数组中的剩余元素放入临时数组中
        while (i <= mid) {
            temp[k++] = array[i++];
        }

        // 如果右子数组还有剩余元素, 将右子数组中的剩余元素放入临时数组中
        while (j <= right) {
            temp[k++] = array[j++];
        }

        // 将临时数组中的元素, 复制回原数组中
        for (i = 0; i < k; i++) {
            array[left + i] = temp[i];
        }
    }
}
