package com.shiro.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.shiro.config.ShiroConstant;
import com.shiro.entity.User;
import com.shiro.mapper.UserMapper;
import com.shiro.service.UserRoleService;
import com.shiro.service.UserService;
import com.shiro.util.SaltUtil;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRoleService userRoleService;

    //user进行注册
    @Override
    @Transactional
    public void register(User user) {
        // 生成随机盐
        String salt = SaltUtil.getSalt(ShiroConstant.SALT_LENGTH);
        // 保存随机盐
        user.setSalt(salt);
        // 生成密码
        Md5Hash password = new Md5Hash(user.getPassword(), salt, ShiroConstant.HASH_ITERATORS);
        // 保存密码
        user.setPassword(password.toHex());
        userMapper.insert(user);
        userRoleService.register(user);
    }

    @Override
    public User findUserByUserName(String userName) {
        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("username",userName);
        return userMapper.selectOne(queryWrapper);
    }

    //功能页面中对所有用户进行查询
    @Override
    public List<User> userSelect() {
        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
        List<User> userList=userMapper.selectList(queryWrapper);
        return userList;
    }

    //对staff进行注册
    public void staffregister(User user){
        String salt = SaltUtil.getSalt(ShiroConstant.SALT_LENGTH);
        user.setSalt(salt);
        Md5Hash password = new Md5Hash(user.getPassword(), salt, ShiroConstant.HASH_ITERATORS);
        user.setPassword(password.toHex());
        userMapper.insert(user);
        userRoleService.staffregister(user);
    }

    @Override
    public User userByNaem(String name) {
        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("username",name);
        User user=userMapper.selectOne(queryWrapper);
        return user;
    }

}

