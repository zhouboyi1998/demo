package com.cafe.sort;

/**
 * @Project: demo
 * @Package: com.cafe.sort
 * @Author: zhouboyi
 * @Date: 2024/10/18 10:03
 * @Description: 堆排序 (大根堆, 升序)
 */
public class HeapSort implements Sort {

    @Override
    public void sort(int[] array) {
        int length = array.length;

        // 构建初始堆 (第一轮遍历, 找出整个数组的最大值, 移动到根节点)
        for (int i = length / 2 - 1; i >= 0; i--) {
            maxHeapify(array, length, i);
        }

        // 从后往前遍历
        for (int i = length - 1; i > 0; i--) {
            // 将当前根节点 (上一轮遍历找到的最大值) 移动到数组的对应位置上
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            // 继续下一轮遍历, 找到数组仍未排好序的部分中的最大值, 移动到根节点
            maxHeapify(array, i, 0);
        }
    }

    private void maxHeapify(int[] array, int size, int root) {
        // 存储根节点、左子节点、右子节点三者中最大值的下标
        int max = root;
        // 左子节点的下标
        int left = 2 * root + 1;
        // 右子节点的下标
        int right = 2 * root + 2;

        // 比较根节点、左子节点、右子节点, 找出最大值的下标
        if (left < size && array[left] > array[max]) {
            max = left;
        }
        if (right < size && array[right] > array[max]) {
            max = right;
        }

        // 如果根节点的下标 != 最大值的下标
        if (root != max) {
            // 交换根节点与最大值的位置
            int temp = array[root];
            array[root] = array[max];
            array[max] = temp;

            // 递归处理受影响的子树
            maxHeapify(array, size, max);
        }
    }
}
