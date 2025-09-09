package com.kei.tliaswebmanagement1.controller;


import com.kei.tliaswebmanagement1.pojo.Emp;
import com.kei.tliaswebmanagement1.pojo.LoginInfo;
import com.kei.tliaswebmanagement1.pojo.Result;
import com.kei.tliaswebmanagement1.service.EmpService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/login")
@RestController
public class LoginController {

    /* 声明日志记录器*/
    private static final Logger log = LoggerFactory.getLogger(LoginController.class);

    /* 注入Service*/
    @Autowired
    private EmpService empService;


    @PostMapping
    public Result login(@RequestBody Emp emp){
        log.info("员工登录：{}",emp);
        LoginInfo loginInfo = empService.login(emp);
        if(loginInfo != null){
            return Result.success(loginInfo);
        }else {
            return Result.error("用户名或密码错误");
        }
    }
}
