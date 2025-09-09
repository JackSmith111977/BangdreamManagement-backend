package com.kei.tliaswebmanagement1.interceptor;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/* 拦截器*/

/* 定义拦截器*/

@Component
public class DemoInterceptor implements HandlerInterceptor {

    /* 声明日志记录器*/
    private static final Logger log = LoggerFactory.getLogger(DemoInterceptor.class);

    // preHandle: 在目标资源方法运行前运行（Controller方法调用之前）--返回值 true：放行，false：拦截
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("拦截器 preHandle ...");
        return false;
    }

    // postHandle: 在目标资源方法运行后运行（Controller方法调用之后，视图渲染之前）
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("拦截器 postHandle ...");
    }

    // afterCompletion: 在目标资源方法运行完成后运行（Controller方法调用之后，视图渲染之后）
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
       log.info("拦截器 afterCompletion ...");
    }
}
