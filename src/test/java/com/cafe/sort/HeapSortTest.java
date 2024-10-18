package com.cafe.sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @Project: demo
 * @Package: com.cafe.sort
 * @Author: zhouboyi
 * @Date: 2024/10/18 14:40
 * @Description: {@link HeapSort}
 */
public class HeapSortTest {

    @Test
    void test() {
        int[] array = {64, 34, 25, 12, 22, 11, 90};
        Sort sort = new HeapSort();
        sort.sort(array);
        Arrays.stream(array).forEach(item -> System.out.print(item + " "));
    }
}
