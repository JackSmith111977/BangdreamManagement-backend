package com.kei.tliaswebmanagement1.filter;

import com.kei.tliaswebmanagement1.utils.CurrentHolder;
import com.kei.tliaswebmanagement1.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;

import java.io.IOException;
import java.util.Map;

/* 过滤器*/

//@WebFilter("/*")//  拦截所有请求
public class TokenFilter implements Filter {
    /* 日志记录器*/
    private static final Logger log = LoggerFactory.getLogger(TokenFilter.class);


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //1. 获取请求路径
        HttpServletRequest request = (HttpServletRequest) servletRequest;// 强转
        HttpServletResponse response = (HttpServletResponse) servletResponse;// 强转

        String path = request.getRequestURI();


        //2. 判断是否登录请求，包含/login，是登录请求，放行
        if (path.contains("/login")){
            log.info("登录请求，放行~喵");
            filterChain.doFilter(request,response);
            return;
        }
        //3. 获取token
        String token = request.getHeader("token");


        //4. 判断token是否存在，不存在，返回错误信息，存在，则放行（错误码401）
        if (token == null||token.isEmpty()){
            log.info("token为空，用户请先登录~喵");
            response.setStatus(401);
            return;
        }


        //5. 解析校验token，如果校验失败，返回错误信息，校验成功，则放行（错误码401）
        try {
            Map<String, Object> claims = JwtUtils.parseToken(token);
            // 将当前用户id保存到当前线程中
            //Integer empId = Integer.valueOf(claims.get("id").toString());
            Integer empId = (Integer) claims.get("id");
            CurrentHolder.setCurrentLocal(empId);
            log.info("当前用户id为："+empId+"，并存入ThreadLocal");
        }catch (Exception e){
            log.info("token解析失败，用户请重新登录~喵");
            response.setStatus(401);
            return;
        }
        //6. 令牌合法，放行
        filterChain.doFilter(request,response);

        //7. 删除ThreadLocal中的数据
        CurrentHolder.removeCurrentLocal();

    }
}
