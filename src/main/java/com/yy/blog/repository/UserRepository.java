package com.yy.blog.repository;

import com.yy.blog.domain.User;
import java.util.List;

public interface UserRepository {

    /**
     * 新增或编辑用户
     * @param user
     * @return
     */
    User saveOrUpdateUser(User user);

    /**
     * 删除用户
     * @param id
     */
    void delUser(Long id);

    /**
     * 查询单个用户
     * @param id
     * @return
     */
    User getUserById(Long id);

    /**
     * 查询用户列表
     * @return
     */
    List<User> listUsers();
}
