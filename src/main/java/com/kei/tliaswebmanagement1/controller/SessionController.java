package com.kei.tliaswebmanagement1.controller;

import com.kei.tliaswebmanagement1.pojo.Result;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SessionController {
    /* 声明日志记录器*/
    private static final Logger log = LoggerFactory.getLogger(SessionController.class);
    /*------------------------------cookie会话跟踪技术----------------------------*/
    /*
    * 优点：
    * http支持
    * */
    /*
    * 缺点：
    * 移动端app无法使用
    * 不安全，用户可以禁用cookie
    * 无法跨域
    */
    // 设置cookie
    @GetMapping("/c1")
    public Result setCookie(HttpServletResponse response){
        response.addCookie(new Cookie("Login_username","kei"));// 设置cookie
        return Result.success();
    }

    // 获取cookie
    @GetMapping("/c2")
    public Result getCookie(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();// 获取所有cookie
        for (Cookie cookie : cookies) {// 遍历cookie,找到Login_username
            if (cookie.getName().equals("Login_username")){
                System.out.println("Login_username"+cookie.getValue());// 打印cookie
            }
        }
        return Result.success();
    }
    /*------------------------------session会话跟踪技术----------------------------*/
    /*
    * 优点：
    * 储存在服务器端，安全，只发送唯一标识，根据唯一标识，服务器返回对应的value
    */
    /*
    * 缺点：
    * 服务器集群下无法使用
    * 移动端app无法使用
    * 无法跨域
    */
    @GetMapping("/s1")
    public Result session1(HttpSession session){
        log.info("HttpSession-s1,{}",session.hashCode());

        session.setAttribute("loginUser","kei");// 设置session
        return Result.success();
    }

    @GetMapping("/s2")
    public Result session2(HttpSession session){
        log.info("HttpSession-s2,{}",session.hashCode());
        Object loginUser = session.getAttribute("loginUser");// 获取session
        log.info("loginUser:{}",loginUser);
        return Result.success(loginUser);
    }
}
