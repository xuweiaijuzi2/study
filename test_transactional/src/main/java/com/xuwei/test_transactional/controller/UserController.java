package com.xuwei.test_transactional.controller;

import com.github.pagehelper.PageInfo;
import com.xuwei.test_transactional.bean.User;
import com.xuwei.test_transactional.service.UserService;
import org.springframework.web.bind.annotation.*;

/**
 * @program: study
 * @Date: 2024/10/18 10:46
 * @Author: Mr.Xu
 * @Description:
 */
@RestController
@RequestMapping("/user")
public class UserController {
    /**
     * 怎加注释11111
     */

    private UserService userService;


    /*构造器注入*/
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("test/{message}")
    public String test(@PathVariable(value = "message") String message){

        return "I have received your message,it is " + message;
    }

    @PostMapping("/addOne")
    public String addOne(@RequestBody User user){
        if (user == null || user.getName() == null)
            return "参数为空";
        System.out.println(user);
        userService.addOne(user);
        return "插入成功";
    }

    /**
     * 使用pagehelper实现分页查查询  TODO 大数据表的分页查询怎么优化？
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/users")
    public PageInfo<User> getUsers(@RequestParam int pageNum, @RequestParam int pageSize) {
        return userService.getUsers(pageNum, pageSize);
    }
}