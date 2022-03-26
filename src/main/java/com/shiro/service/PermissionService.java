package com.shiro.service;

import com.shiro.entity.Permission;

import java.util.List;

public interface PermissionService {

    List<Permission> getPermissionsByRoleId(Integer roleId);
}
