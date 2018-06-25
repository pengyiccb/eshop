package com.tfx0one.center.AccountCenter.JwtAuth;

import com.alibaba.fastjson.JSONObject;
import com.tfx0one.center.AccountCenter.model.EShopRolePermission;
import com.tfx0one.center.AccountCenter.service.RolePermissionService;
import com.tfx0one.common.constant.APIConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by 2fx0one on 2018/6/4.
 */

@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    //自动装配JwtUserDetailService 把jwt 集成到 security
    @Autowired
    private JwtUserService jwtUserService;

    @Resource
    private RolePermissionService rolePermissionService;

    @Autowired
    private JWTokenUtils JWTokenUtils;

    @Value("${jwt.header}")
    private String tokenHeader;

    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @Override
    protected void doFilterInternal(
            HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        String authHeader = request.getHeader(this.tokenHeader);
        logger.info(" 收到 request url = " + request.getRequestURL() + "  Authorization = \"" + authHeader + "\"");

        //对于所有的请求， 如果包含token 都需要嵌入 进行验证 然后再走原来的请求链。filterChain.doFilter
        if (authHeader != null && authHeader.startsWith(tokenHead) && authHeader.length() > tokenHead.length() + 1) {
//            logger.info("authentication authHeader = [ " + authHeader + " ]");
            final String authToken = authHeader.substring(tokenHead.length() + 1); // The part after "Bearer " 用空格
            String username = JWTokenUtils.getUsernameFromToken(authToken);

            logger.info("authentication username = " + username);
//            //TODO 验证失败时。需要返回信息
            if (username == null) {
                errorStrWriteToResponse(response, APIConstant.TOKEN_ILLEGAL, "失效的 Token， username == null");
                return;
            }

            //需要验证的页面，加入到授权上下文
            if (SecurityContextHolder.getContext().getAuthentication() == null) {
                logger.info("checking authentication ===== " + username);

                JWTokenUser userDetails = jwtUserService.loadUserByUsername(username);

                //验证token 和 userDetail 是否一致
                if (JWTokenUtils.validateToken(authToken, userDetails)) {
                    logger.info(" ===== SecurityContextHolder.getContext().setAuthentication(authentication); =====" + username);

                    //把用户信息放到 SecurityContextHolder
                    UsernamePasswordAuthenticationToken authentication
                            = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

                    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                    SecurityContextHolder.getContext().setAuthentication(authentication);
                } else {
                    errorStrWriteToResponse(response, APIConstant.TOKEN_ILLEGAL, "validateToken 验证失败 Token");
                    return;
                }

                //权限已经注入 SecurityContextHolder。接下来需要验证用户可以访问url的权限。
                //用户数据
                List<EShopRolePermission> permissions = rolePermissionService.selectRolePermissionByRoleId(userDetails.getRoleId());

                String uri = request.getRequestURI(); //请求路径
                String ctx = request.getContextPath();
                String path = uri.replace(ctx, "");

                Set<String> urlSet = permissions.stream().map(EShopRolePermission::getUrl).collect(Collectors.toSet());
                if (! urlSet.contains(path)) { //不包含。无权限
                    errorStrWriteToResponse(response, APIConstant.TOKEN_ACCESS_DENIED, "URL Access Denied 无权访问该链接！ path = " + path);
                    return;
                }


//                for( String url : permissions.stream().map(EShopRolePermission::getUrl).collect(Collectors.toSet())) {
//                    if(new AntPathRequestMatcher(url)
//                            .matches(request)) {
////                        return
//                        //匹配 返回权限集合
////                        return map.get(url);
//                    }
//                }


            }


        }
        filterChain.doFilter(request, response);
    }

    private void errorStrWriteToResponse(HttpServletResponse response, int code, String errorCode) throws IOException {
//        String errStr = "{\"code\":" + code + "" + new Date().toString() + ",\"msg\":\"" + errorCode + "\"}";

        Map<String, Object> map = new HashMap<>();
        map.put("code", code);
        map.put("timestamp", new Date().toString());
        map.put("msg", errorCode);

        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        response.getWriter().println(JSONObject.toJSONString(map));
//        throw new AccessDeniedException("Access Denied！");
    }

}
