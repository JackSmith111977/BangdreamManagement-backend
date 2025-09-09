package com.kei.tliaswebmanagement1.config;

import com.kei.tliaswebmanagement1.interceptor.DemoInterceptor;
import com.kei.tliaswebmanagement1.interceptor.TokenInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration// 配置类
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private DemoInterceptor demoInterceptor;

    @Autowired
    private TokenInterceptor tokenInterceptor;

    /* 注册拦截器*/

    /*
    * 1.拦截器路径  “/*”  只能拦截下一级路径，  “/**”  才能拦截下任意级路径
    * 2.先经过滤器，再经过拦截器
    */

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(tokenInterceptor)
                .addPathPatterns("/**")// 拦截所有请求
                .excludePathPatterns("/login")// 放行登录请求
        ;
    }
}
