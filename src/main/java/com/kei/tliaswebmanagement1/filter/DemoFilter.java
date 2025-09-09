package com.kei.tliaswebmanagement1.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;



/* 多个过滤器可以形成过滤器链，默认字母顺序（a先于b）先后执行过滤器
*  先进后出
*/

//@WebFilter("/*")// 拦截所有请求
//@WebFilter("/login")// 拦截指定目录请求
public class DemoFilter implements Filter {
    /* 日志记录器*/
    private static final Logger log = LoggerFactory.getLogger(DemoFilter.class);


    /* 初始化方法，服务器启动时执行一次，只执行一次*/
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("过滤器初始化~喵");
        Filter.super.init(filterConfig);
    }

    /* 过滤方法，每次请求时执行*/
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        log.info("拦截到了请求~喵");
        // 放行
        filterChain.doFilter(servletRequest, servletResponse);


    }

    /* 销毁方法，web服务器关闭是执行，只执行一次*/
    @Override
    public void destroy() {
        log.info("过滤器销毁~汪");
        Filter.super.destroy();
    }
}
