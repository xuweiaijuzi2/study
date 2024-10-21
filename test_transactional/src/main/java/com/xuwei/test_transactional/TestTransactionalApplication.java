package com.xuwei.test_transactional;

import com.xuwei.test_transactional.config.ThreadPoolParam;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class TestTransactionalApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(TestTransactionalApplication.class, args);
        ThreadPoolParam threadPoolParam = (ThreadPoolParam)run.getBean("threadPoolParam");
        System.out.println("-----------------------------------------");
//        System.out.println("thread-pool-param");
//        System.out.println("corePoolSize: "+threadPoolParam.getCorePoolSize());
//        System.out.println("maximumPoolSize: "+threadPoolParam.getMaximumPoolSize());
//        System.out.println("unit: "+threadPoolParam.getUnit());
//        System.out.println("keepAliveTime: "+threadPoolParam.getKeepAliveTime());

        System.out.println(threadPoolParam);
        System.out.println("-----------------------------------------");
    }
}
