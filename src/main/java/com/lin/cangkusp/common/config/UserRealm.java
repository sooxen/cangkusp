package com.lin.cangkusp.common.config;

import com.lin.cangkusp.pojo.User;
import com.lin.cangkusp.service.UserService;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.nio.file.attribute.UserPrincipalNotFoundException;


public class UserRealm extends AuthorizingRealm {
    @Autowired
    private UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken upToken = (UsernamePasswordToken) token;
        User user = userService.queryUserById(upToken.getUsername());
        if (user==null || StringUtils.isBlank(user.getSno())) {
            throw  new UnknownAccountException("用户名或密码错误！");
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user.getSno(), user.getUpwd(), getName());
        return authenticationInfo;
    }
}
