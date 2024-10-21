
package com.xuwei.test_transactional.mapper;

import com.xuwei.test_transactional.bean.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @program: study
 * @Date: 2024/10/18 10:59
 * @Author: Mr.Xu
 * @Description:
 */

@Mapper
public interface UserMapper {

    public void addOne(User user);

    void selectPage(int pageSize,int pageNumber);

    List<User> getUsers(int pageNum, int pageSize);
}

