package com.kei.tliaswebmanagement1.anno;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// @Target元注解，指定在哪里生效，这里ElementType.METHOD表示注解作用在方法上
@Target(ElementType.METHOD)
// @Retention元注解，指定什么时候生效，这里RetentionPolicy.RUNTIME表示在运行时生效
@Retention(RetentionPolicy.RUNTIME)
public @interface LogOperation {
}
