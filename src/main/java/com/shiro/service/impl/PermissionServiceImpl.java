package com.shiro.service.impl;


import com.shiro.entity.Permission;
import com.shiro.mapper.PermissionMapper;
import com.shiro.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("permissionService")
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public List<Permission> getPermissionsByRoleId(Integer roleId) {
        return permissionMapper.getPermissionsByRoleId(roleId);
    }

}
