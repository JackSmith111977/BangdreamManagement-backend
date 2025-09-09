package com.kei.tliaswebmanagement1;

import com.kei.tliaswebmanagement1.utils.AliyunOSSOperator;
import com.kei.tliaswebmanagement1.utils.AliyunOSSProperties;
import com.kei.tliaswebmanagement1.utils.MyImportSelector;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

/* 自动配置*/
// 自动配置方案一：@Component+@ComponentScan,扫描第三方依赖 --使用繁琐，效率低
// @ComponentScan(basePackages = {"com.kei.other"})// 指定扫描的包,加此注解后默认扫描范围不生效

// 自动配置方案二：@Import 导入类（普通类、配置类、ImportSelector接口实现类-批量导入）
// @Import(AliyunOSSProperties.class)
//@Import(MyImportSelector.class)

// 自动配置方案三：@Enablexxxxx(第三方工具类提供者的封装的包含@Import注解的注解类)

// @Conditional 条件注解，父注解 -- 根据条件判断是否进行自动配置
// @ConditionalOnClass(name = "全类名") -- 判断环境中是否有对应字节码文件，才注册bean到IOC容器中
// @ConditionalOnMissingBean -- 判断环境中没有对应bean，才注册bean到IOC容器中
// @ConditionalOnProperty(name="属性名",havingValue="属性值") -- 判断环境中指定的属性是否为指定的值，才注册bean到IOC容器中

@ServletComponentScan// 扫描Servlet、Filter、Listener
@SpringBootApplication
public class TliasWebManagement1Application {

	public static void main(String[] args) {
		SpringApplication.run(TliasWebManagement1Application.class, args);
	}



}
