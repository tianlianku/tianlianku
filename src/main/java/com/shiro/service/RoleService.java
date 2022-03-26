package com.shiro.service;

import com.shiro.entity.Role;

import java.util.List;

public interface RoleService {

    List<Role> getRoleByUserId(Integer userid);
}
