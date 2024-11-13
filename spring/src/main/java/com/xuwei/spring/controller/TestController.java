package com.xuwei.spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: study
 * @Date: 2024/11/7 11:37
 * @Author: Mr.Xu
 * @Description: 测试使用
 */
@RestController
@RequestMapping(value = "/test")
public class TestController {

    @GetMapping(value = "/getMappingTest/{name}/{age}")
    public String getMappingTest(@PathVariable(value = "name") String name,@PathVariable(value = "age") int age){
        System.out.println(name + "  " + age);
        return name + "  " + age;
    }
}
