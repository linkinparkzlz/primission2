package com.zou.primission2;

import com.zou.primission2.model.Permission;
import com.zou.primission2.model.Role;
import com.zou.primission2.model.User;
import com.zou.primission2.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class AuthRealm extends AuthorizingRealm {


    @Autowired
    private UserService userService;


    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        User user = (User) principalCollection.fromRealm(this.getClass().getName()).iterator().next();
        List<String> permissionList = new ArrayList<>();
        Set<Role> roleSet = user.getRoles();

        if (!CollectionUtils.isEmpty(permissionList)) {

            for (Role role : roleSet) {
                Set<Permission> permissionSet = role.getPermissions();

                if (!CollectionUtils.isEmpty(permissionSet)) {

                    for (Permission permission : permissionSet) {

                        permissionList.add(permission.getName());
                    }
                }

            }
        }

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addStringPermissions(permissionList);

        return info;
    }


    //认证登录
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {


        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;

        String username = usernamePasswordToken.getUsername();

        User user = userService.findByUsername(username);

        return new SimpleAuthenticationInfo(user, user.getPassword(), this.getClass().getName());
    }
}














