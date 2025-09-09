package com.kei.tliaswebmanagement1.controller;

import com.kei.tliaswebmanagement1.anno.Log;
import com.kei.tliaswebmanagement1.pojo.Dept;
import com.kei.tliaswebmanagement1.pojo.Result;
import com.kei.tliaswebmanagement1.service.DeptService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/* lombok日志记录器注解*/
//@Slf4j
/* Controller: 接收请求，处理响应*/
// 公共的请求路径可以抽取到类上
// @RequestMapping("/depts")

/* 默认的bean是单例：singleton 在项目启动前创建，只创建一次，存入IOC容器
* @Lazy 延迟初始化注解，延迟到第一次使用该bean
* @Scope("...") 设置bean类型注解
* prototype 多例的,每次使用都要创建一个bean对象*/

/* 无状态bean：不保存数据 常用单例bean，节约资源，提高效率
* 有状态的bean：保存数据 常用多例bean，保障线程间数据安全*/
@Scope("prototype")
@RestController
public class DeptController {
    /* 声明日志记录器*/
    //除了文件名，其余代码固定
    //使用了lombok，只需要添加@Slf4j注解
    private static final Logger log = LoggerFactory.getLogger(DeptController.class);

    @Autowired
    private DeptService deptService;

    /* 规定只能使用get方法请求*/
    //方法一
    //@RequestMapping(value = "/depts",method = RequestMethod.GET)
    //方法二
    @GetMapping("/depts")
    public Result list(){
        // System.out.println("查询全部乐队数据");
        /* 基于Slf4j的日志输出*/
        log.info("查询全部乐队数据");
        List<Dept> deptList = deptService.findAll();
        return Result.success(deptList);
    }

    /* 删除部门*/
    // 方式一：获取请求参数，使用httpServletRequest接收
//    @DeleteMapping("/depts")
//    public Result deleteById(HttpServletRequest request){
//
//        String idStr = request.getParameter("id");
//        int id = Integer.parseInt(idStr);
//        System.out.println("根据id删除乐队数据："+idStr);
//        return Result.success();
//    }
    // 方式二：使用@RequestParam注解接收请求参数
    // @RequestParam的required属性，默认为true，表示请求参数必须传，否则报错,可手动改为false
//    @DeleteMapping("/depts")
//    public Result deleteById(@RequestParam(value = "id",required = false) Integer deptId){
//        System.out.println("根据id删除乐队数据："+deptId);
//        return Result.success();
//    }
    // 方式三：请求参数名与形参名一致，可以省略@RequestParam注解
    @Log
    @DeleteMapping("/depts")
    public Result deleteById(@RequestParam Integer id){
        //System.out.println("根据id删除乐队数据："+id);
        log.info("根据id删除乐队数据：{}",id);
        deptService.deleteById(id);
        return Result.success();
    }

    /* 新增乐队*/
    // @RequestBody注解：将请求体中json格式的数据，转为java对象，对象中的属性名必须与json数据中的属性名一致
    @Log
    @PostMapping("/depts")
    public Result add(@RequestBody Dept dept){

//        System.out.println("添加乐队"+dept.getName());
        log.info("新增乐队：{}",dept.getName());
        deptService.add(dept);
        return Result.success();
    }

    /* 根据id查询信息*/
    // @PathVariable注解：将请求地址中占位符的值，赋值给形参
    // 当占位符的名称与形参名称一致，可以省略@PathVariable注解的value值
    @GetMapping("/depts/{id}")
//    public Result getInfo(@PathVariable("id") Integer deptId){
//        System.out.println("根据id查询信息："+deptId);
//        List<Dept> deptList = deptService.getInfo(deptId);
//        return Result.success(deptList);
//    }
    public Result getInfo(@PathVariable Integer id){
        //System.out.println("根据id查询信息："+id);
        log.info("根据id查询信息：{}",id);
        Dept dept = deptService.getInfo(id);
        return Result.success(dept);
    }

    /* 修改信息*/
    @Log
    @PutMapping("/depts")
    public Result update(@RequestBody Dept dept){
//        System.out.println("修改信息："+dept.getName());
        log.info("修改信息：{}",dept.getName());
        deptService.update(dept);
        return Result.success();
    }
}
