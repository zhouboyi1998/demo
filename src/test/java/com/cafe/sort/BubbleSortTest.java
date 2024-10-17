package com.cafe.sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @Project: demo
 * @Package: com.cafe.sort
 * @Author: zhouboyi
 * @Date: 2024/10/17 20:48
 * @Description: {@link BubbleSort}
 */
public class BubbleSortTest {

    @Test
    void test() {
        int[] array = {64, 34, 25, 12, 22, 11, 90};
        Sort sort = new BubbleSort();
        sort.sort(array);
        Arrays.stream(array).forEach(item -> System.out.print(item + " "));
    }
}
