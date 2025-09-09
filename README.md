# TLias Web Management System

基于Spring Boot的企业级后台管理系统(套皮成Bangdream少女乐队的形式了)，提供员工管理、部门管理、班级管理、学生管理等核心功能。

## 项目简介

TLias Web Management System 是一个完整的企业管理后台系统，采用现代化的Java技术栈构建，具备完善的权限控制、日志记录、数据统计等功能。

## 技术栈

- **后端框架**: Spring Boot
- **持久层**: MyBatis + MyBatis-Plus
- **数据库**: MySQL
- **安全框架**: JWT Token认证
- **对象存储**: 阿里云OSS
- **API文档**: Swagger/OpenAPI
- **构建工具**: Maven

## 核心功能模块

### 1. 用户认证与权限管理
- JWT Token登录认证
- Session会话管理
- Token拦截器权限验证
- 全局异常处理

### 2. 组织架构管理
- 部门管理 
- 员工管理
- 班级管理

### 3. 学生管理系统
- 学生信息管理
- 学生数据统计

### 4. 系统监控与日志
- 操作日志记录
- 员工操作日志
- AOP切面编程监控

### 5. 文件管理
- 文件上传下载
- 阿里云OSS集成

## 项目结构
├── anno # 自定义注解 <br>
├── aop # AOP切面逻辑 <br>
├── config # 配置类 <br>
├── controller # 控制器层 <br>
├── exception # 异常处理 <br>
├── filter # 过滤器 <br>
├── interceptor # 拦截器 <br>
├── mapper # 数据访问层 <br>
├── pojo # 实体类 <br>
├── service # 业务逻辑层 <br>
└── utils # 工具类

## 环境要求

- JDK 8+
- MySQL 5.7+
- Maven 3.6+
- 阿里云OSS账号（可选）

## 配置文件

### application.yml 主要配置项：

~~~yml
服务器配置
server: port: 8080
数据库配置
spring: 
  datasource: 
  url: jdbc:mysql://localhost:3306/tlias_db 
  username: your_username 
  password: your_password 
  driver-class-name: com.mysql.cj.jdbc.Driver
阿里云OSS配置
aliyun: 
  oss: endpoint: your-oss-endpoint 
  accessKeyId: your-access-key-id 
  accessKeySecret: your-access-key-secret bucketName: your-bucket-name
~~~

## 快速开始

1. 克隆项目
~~~
git clone <repository-url>
~~~
2. 创建数据库并导入初始化脚本

3. 修改 application.yml 中的数据库配置

4. 使用Maven构建项目
~~~
mvn clean install
~~~
5. 运行应用
~~~
mvn spring-boot:run
~~~

## 安全说明

- 所有API接口均需Token认证
- 敏感操作记录操作日志
- 密码加密存储
- SQL注入防护

## 许可证

本项目仅供学习交流使用。


