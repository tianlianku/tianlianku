package com.shiro.service;

import com.shiro.entity.User;

import java.util.List;

public interface UserService {
    /**
     * 用户注册
     * @param user
     */
    void register(User user);

    User findUserByUserName(String userName);

    List<User> userSelect();

    void staffregister(User user);

    User userByNaem(String name);
}

