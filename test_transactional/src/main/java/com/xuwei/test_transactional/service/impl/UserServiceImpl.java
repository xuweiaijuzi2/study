package com.xuwei.test_transactional.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xuwei.test_transactional.bean.User;
import com.xuwei.test_transactional.mapper.UserMapper;
import com.xuwei.test_transactional.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @program: study
 * @Date: 2024/10/18 10:57
 * @Author: Mr.Xu
 * @Description:
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ThreadPoolExecutor executor;

    @Transactional
    @Override
    public void addOne(User user) {
        userMapper.addOne(user);
    }

    @Override
    public PageInfo<User> getUsers(int pageNum, int pageSize) {
        /*executor.submit(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });*/
        PageHelper.startPage(pageNum, pageSize);
        List<User> users = userMapper.getUsers(pageNum,pageSize);
        return new PageInfo<>(users);
    }
}
