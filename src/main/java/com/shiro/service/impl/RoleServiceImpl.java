package com.shiro.service.impl;

import com.shiro.entity.Role;
import com.shiro.mapper.RoleMapper;
import com.shiro.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("roleService")
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<Role> getRoleByUserId(Integer userid) {
        return roleMapper.getRoleByUserId(userid);
    }
}
