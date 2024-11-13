package com.xuwei.test_transactional.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @program: study
 * @Date: 2024/10/21 15:06
 * @Author: Mr.Xu
 * @Description:
 */
@Configuration
public class ThreadPoolConfig {

    @Bean
    public ThreadPoolExecutor threadPoolExecutor(ThreadPoolParam param){


        // 定义线程池参数
        int corePoolSize = param.getCorePoolSize();        // 核心线程数
        int maximumPoolSize = param.getMaximumPoolSize();    // 最大线程数
        long keepAliveTime = param.getKeepAliveTime();      // 线程空闲时间
        TimeUnit unit = param.getUnit(); // 时间单位
        BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<>(); // 任务队列

        // 创建线程池
        return new ThreadPoolExecutor(
                corePoolSize,
                maximumPoolSize,
                keepAliveTime,
                unit,
                workQueue
        );
    }
}
