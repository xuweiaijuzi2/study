package com.xuwei.juc.test01;

import java.util.concurrent.*;

/**
 * @program: study
 * @Date: 2024/10/10 14:46
 * @Author: Mr.Xu
 * @Description:
 */
public class ThreadPoolExample {
    public static void main(String[] args) {
        // 定义线程池参数
        int corePoolSize = 4;        // 核心线程数
        int maximumPoolSize = 10;    // 最大线程数
        long keepAliveTime = 60;      // 线程空闲时间
        TimeUnit unit = TimeUnit.SECONDS; // 时间单位
        BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<>(); // 任务队列

        // 创建线程池
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                corePoolSize,
                maximumPoolSize,
                keepAliveTime,
                unit,
                workQueue
        );

        // 提交任务
        for (int i = 0; i < 20; i++) {
            final int taskId = i;
            executor.submit(() -> {
                System.out.println("Executing task " + taskId + " in thread " + Thread.currentThread().getName());
                try {
                    Thread.sleep(1000); // 模拟任务处理
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }

        // 关闭线程池
        executor.shutdown();
    }
}
