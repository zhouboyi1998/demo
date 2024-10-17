package com.cafe.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Project: demo
 * @Package: com.cafe.sort
 * @Author: zhouboyi
 * @Date: 2024/10/17 21:51
 * @Description: {@link QuickSort}
 */
public class QuickSortTest {

    @Test
    public void test() {
        int[] array = {64, 34, 25, 12, 22, 11, 90};
        int start = 0;
        int end = array.length - 1;
        QuickSort.sort(array, start, end);
        Arrays.stream(array).forEach(item -> System.out.print(item + " "));
    }
}
