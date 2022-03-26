package com.shiro.config;

import com.shiro.entity.Permission;
import com.shiro.entity.Role;
import com.shiro.entity.User;
import com.shiro.service.PermissionService;
import com.shiro.service.RoleService;
import com.shiro.service.UserService;
import com.shiro.util.ApplicationContextUtil;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import java.util.List;

/**
 * 自定义realm
 */
public class CustomerRealm extends AuthorizingRealm {
    // 授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

        String principal=(String) principals.getPrimaryPrincipal();
        UserService userService=(UserService) ApplicationContextUtil.getBean("userServiceImpl");
        User user=userService.findUserByUserName(principal);
        RoleService roleService=(RoleService)ApplicationContextUtil.getBean("roleService");
        List<Role> listrole=roleService.getRoleByUserId(user.getId());
        if(!CollectionUtils.isEmpty(listrole)){
            SimpleAuthorizationInfo authorizationInfo=new SimpleAuthorizationInfo ();
            listrole.forEach(role->{
                authorizationInfo.addRole(role.getName());
                PermissionService permissionService = (PermissionService) ApplicationContextUtil.getBean("permissionService");
                List<Permission> permissions = permissionService.getPermissionsByRoleId(role.getId());
                if(!CollectionUtils.isEmpty(permissions)){
                    permissions.forEach(permission -> {
                        authorizationInfo.addStringPermission(permission.getName());
//                        authorizationInfo.addStringPermission("staff:common:*");
//                        authorizationInfo.addStringPermission("user:private:*");
                    });
                }
            });
            return authorizationInfo;
        }

        return null;
    }

    // 认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        // 获取当前登录的主题
        String principal = (String) token.getPrincipal();
        // 由于CustomerRealm并没有交由工厂管理，故不能诸如UserService
        UserService userService = (UserService) ApplicationContextUtil.getBean("userServiceImpl");
        User user = userService.findUserByUserName(principal);
        if(!ObjectUtils.isEmpty(user)){
            return new SimpleAuthenticationInfo(user.getUsername(),user.getPassword(), new CustomerByteSource(user.getSalt()),this.getName());
        }
        return null;
    }

}

