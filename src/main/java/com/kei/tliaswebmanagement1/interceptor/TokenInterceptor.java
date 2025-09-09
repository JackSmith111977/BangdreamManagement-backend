package com.kei.tliaswebmanagement1.interceptor;

import com.kei.tliaswebmanagement1.utils.CurrentHolder;
import com.kei.tliaswebmanagement1.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.HashMap;
import java.util.Map;


/* 令牌校验拦截器*/
@Component
public class TokenInterceptor implements HandlerInterceptor {

    /* 声明日志记录器*/
    private static final Logger log = LoggerFactory.getLogger(TokenInterceptor.class);


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 1.获取请求路径
        String requestURI = request.getRequestURI();

        // 2.判断是否是登录请求，如果是，放行，否则拦截
        if (requestURI.contains("/login")){
            log.info("登录请求，放行");
            return true;
        }

        // 3.获取token
        String token = request.getHeader("token");

        // 4.判断token是否存在，不存在，返回错误信息，存在，则放行（错误码401）
        if (token == null || token.isEmpty()){
            log.info("token为空，返回错误信息");
            response.setStatus(401);
            return false;
        }

        // 5. 解析校验token，如果校验失败，返回错误信息，校验成功，则放行（错误码401）
        try {
            Map<String, Object> claims = JwtUtils.parseToken(token);
            // 将当前用户id保存到当前线程中
            Integer empId = Integer.valueOf(claims.get("id").toString());
            //Integer empId = (Integer) claims.get("id");
            CurrentHolder.setCurrentLocal(empId);
            log.info("当前用户id为："+empId+"，并存入ThreadLocal");
        }catch (Exception e){
            log.info("token解析失败，用户请重新登录~喵");
            response.setStatus(401);
            return false;
        }

        // 6.如果校验成功，则放行
        log.info("token校验成功，放行~");

        return true;


    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // 7.删除ThreadLocal中的数据
        CurrentHolder.removeCurrentLocal();
        log.info("{}",CurrentHolder.getCurrentLocal());
    }
}
