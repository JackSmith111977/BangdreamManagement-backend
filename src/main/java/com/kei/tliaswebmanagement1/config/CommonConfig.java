package com.kei.tliaswebmanagement1.config;

import com.kei.tliaswebmanagement1.utils.AliyunOSSOperator;
import com.kei.tliaswebmanagement1.utils.AliyunOSSProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommonConfig {
    @Bean // 将方法返回值交给 IOC 容器管理，成为IOC的bean对象
    public AliyunOSSOperator aliyunOSSOperator(AliyunOSSProperties aliyunOSSProperties){
        return new AliyunOSSOperator(aliyunOSSProperties);
    }
}
