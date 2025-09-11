package com.cafe.sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @Project: demo
 * @Package: com.cafe.sort
 * @Author: zhouboyi
 * @Date: 2024/10/18 14:57
 * @Description: {@link ShellSort}
 */
public class ShellSortTest {

    @Test
    void test() {
        int[] array = {64, 34, 25, 12, 22, 11, 90};
        Sort sort = new ShellSort();
        sort.sort(array);
        Arrays.stream(array).forEach(item -> System.out.print(item + " "));
    }
}
