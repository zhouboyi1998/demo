package com.cafe.concurrent.future;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Project: demo
 * @Package: com.cafe.concurrent.future
 * @Author: zhouboyi
 * @Date: 2025/6/13 17:18
 * @Description: {@link StreamAndCompletableFuture}
 */
class StreamAndCompletableFutureTest {

    /**
     * 模拟任务ID
     */
    private static final List<Integer> TASK_IDS = new ArrayList<Integer>() {{
        add(1);
        add(2);
        add(3);
        add(4);
        add(5);
        add(6);
        add(7);
        add(8);
        add(9);
    }};

    @Test
    void falseCase() {
        StreamAndCompletableFuture.falseCase(TASK_IDS);
    }

    @Test
    void trueCase() {
        StreamAndCompletableFuture.trueCase(TASK_IDS);
    }
}
