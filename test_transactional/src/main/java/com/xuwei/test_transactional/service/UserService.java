package com.xuwei.test_transactional.service;

import com.github.pagehelper.PageInfo;
import com.xuwei.test_transactional.bean.User;

/**
 * @program: study
 * @Date: 2024/10/18 10:54
 * @Author: Mr.Xu
 * @Description:
 */

public interface UserService {

    public void addOne(User user);

    PageInfo<User> getUsers(int pageNum, int pageSize);
}
