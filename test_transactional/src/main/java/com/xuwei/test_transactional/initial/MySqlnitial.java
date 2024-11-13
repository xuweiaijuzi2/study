package com.xuwei.test_transactional.initial;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @program: study
 * @Date: 2024/10/29 13:57
 * @Author: Mr.Xu
 * @Description:
 */
@Component
@Order(1)
public class MySqlnitial implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("项目启动后马上执行mysql的初始化工作");
    }
}
