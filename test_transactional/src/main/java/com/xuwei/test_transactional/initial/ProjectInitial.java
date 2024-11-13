package com.xuwei.test_transactional.initial;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @program: study
 * @Date: 2024/10/29 13:59
 * @Author: Mr.Xu
 * @Description:
 */
@Component
@Order(3)
public class ProjectInitial implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("项目启动后马上执行project的初始化工作");
    }
}
