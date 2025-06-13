package com.cafe.concurrent.future;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @Project: demo
 * @Package: com.cafe.concurrent.future
 * @Author: zhouboyi
 * @Date: 2025/6/13 16:12
 * @Description: Stream & CompletableFuture
 * <p>
 * 在对 Stream 进行并行化改造的时候
 * 经常因为不希望使用公共的 ForkJoinPool, 导致无法使用 ParallelStream
 * 此时就可以使用 Stream + CompletableFuture 的组合来实现并行化
 */
public class StreamAndCompletableFuture {

    /**
     * 任务执行线程池
     */
    private static final ThreadPoolExecutor TASK_THREAD_POOL = new ThreadPoolExecutor(
        Runtime.getRuntime().availableProcessors() + 1,
        Runtime.getRuntime().availableProcessors() + 1,
        0, TimeUnit.SECONDS,
        new LinkedBlockingQueue<>(1024),
        new ThreadPoolExecutor.CallerRunsPolicy()
    );

    /**
     * 模拟任务
     */
    private static String mockTask(Integer id) {
        try {
            // 模拟任务耗时
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("任务 [" + id + "] 完成");
        return id.toString();
    }

    /**
     * 错误示例
     *
     * @param ids 任务ID
     */
    public static List<String> falseCase(List<Integer> ids) {
        // 原因1: Stream 流的中间操作是惰性求值的, 只有遇到终止操作才会触发整个流的执行
        // 原因2: 串行流中, 第一个元素执行完所有中间操作后, 第二个元素才能开始执行
        // 导致的结果: 每一个元素的 .map(CompletableFuture::join) 操作会阻塞流程, 无法达到并行执行的效果
        return ids.stream()
            .map(id -> CompletableFuture.supplyAsync(() -> mockTask(id), TASK_THREAD_POOL))
            .map(CompletableFuture::join)
            .collect(Collectors.toList());
    }

    /**
     * 正确示例
     *
     * @param ids 任务ID
     */
    public static List<String> trueCase(List<Integer> ids) {
        // 解释: Collectors.collectingAndThen() 的作用是将结果收集到一个新的 Stream 流中
        // 在以下代码中, 带有 CompletableFuture 的中间操作在遇到 Stream 终止操作前, 没有被 CompletableFuture.join() 阻塞
        // 所有 CompletableFuture 都会开始执行, 并在开始执行后被 Collectors.collectingAndThen() 收集到第二个 Stream 流中
        // 最后在第二个 Stream 流中阻塞等待所有 CompletableFuture 执行完毕
        return ids.stream()
            .map(id -> CompletableFuture.supplyAsync(() -> mockTask(id), TASK_THREAD_POOL))
            .collect(Collectors.collectingAndThen(Collectors.toList(), completableFutureList ->
                completableFutureList.stream().map(CompletableFuture::join).collect(Collectors.toList())
            ));
    }
}
