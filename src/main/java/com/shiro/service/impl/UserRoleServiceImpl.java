package com.shiro.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.shiro.entity.User;
import com.shiro.entity.UserRole;
import com.shiro.mapper.UserRoleMapper;
import com.shiro.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    private UserRoleMapper userRoleMapper;

    //对游客进行注册
    @Override
    @Transactional
    public void register(User user) {
        UserRole userRole=new UserRole();
        userRole.setRoleid(3);
        userRole.setUserid(user.getId());
        userRoleMapper.insert(userRole);
    }

    @Transactional
    public void staffregister(User user) {
        UserRole userRole=new UserRole();
        userRole.setRoleid(2);
        userRole.setUserid(user.getId());
        userRoleMapper.insert(userRole);
    }
}
