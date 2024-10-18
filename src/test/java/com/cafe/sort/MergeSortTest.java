package com.cafe.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Project: demo
 * @Package: com.cafe.sort
 * @Author: zhouboyi
 * @Date: 2024/10/17 23:03
 * @Description: {@link MergeSort}
 */
public class MergeSortTest {

    @Test
    public void test() {
        int[] array = {64, 34, 25, 12, 22, 11, 90};
        int start = 0;
        int end = array.length - 1;
        MergeSort.sort(array, start, end);
        Arrays.stream(array).forEach(item -> System.out.print(item + " "));
    }
}
