package com.tfx0one.center.AccountCenter.JwtAuth;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by 2fx0one on 2018/6/25.
 */

@Component
public class AuthAccessDecisionManager implements AccessDecisionManager {

    // decide() 方法是判定是否拥有权限的决策方法，

    //1 authentication 是释CustomUserService中循环添加到 GrantedAuthority 对象中的权限信息集合.

    //2 object 包含客户端发起的请求的requset信息，可转换为 HttpServletRequest request = ((FilterInvocation) object).getHttpRequest();

    //3 configAttributes 为AuthInvocationSecurityMetadataSource的getAttributes(Object object)这个方法返回的结果，

    @Override
    public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes) throws AccessDeniedException, InsufficientAuthenticationException {
        if (null == configAttributes || configAttributes.size() <= 0) {
            return;
        }

//        //遍历AuthInvocationSecurityMetadataSource的getAttributes。获取配置好的权限
//        for (ConfigAttribute conf : configAttributes) {
//            //遍历该用户的权限 authentication 为在 UserDetailsService 中循环添加到 GrantedAuthority 对象中的权限信息集合
//            for (GrantedAuthority ga : authentication.getAuthorities()) {
//                if (conf.getAttribute().trim().equals(ga.getAuthority())) {
//                    return;
//                }
//            }
//        }

        //配置的
        List<String> configList = configAttributes.stream().map(ConfigAttribute::getAttribute).map(String::trim).collect(Collectors.toList());

        //用户的
        List<String> roleList = authentication.getAuthorities().stream().map(GrantedAuthority::getAuthority).map(String::trim).collect(Collectors.toList());

        //java.util.Collections.disjoint()方 用于为'true'如果两个指定collection中没有相同的元素
//        if (!Collections.disjoint(configList, roleList))

        if (CollectionUtils.containsAny(configList, roleList)) { //两个指定collection中有相同的元素
            return;
        }

        throw new AccessDeniedException("Access Denied！");
    }

    @Override
    public boolean supports(ConfigAttribute attribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }
}
