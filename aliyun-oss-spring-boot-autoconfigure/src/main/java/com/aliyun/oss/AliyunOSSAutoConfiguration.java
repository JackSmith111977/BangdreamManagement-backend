package com.aliyun.oss;


import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/* 自定义起步依赖*/
/* AliyunOSS 的自动配置类*/

@EnableConfigurationProperties(AliyunOSSProperties.class)// 启用配置属性 --基于@Import注解将类导入到IOC
@Configuration
public class AliyunOSSAutoConfiguration {

    @Bean
    public AliyunOSSOperator aliyunOSSOperator(AliyunOSSProperties aliyunOSSProperties){

        return new AliyunOSSOperator(aliyunOSSProperties);
    }
}
