package com.kei.tliaswebmanagement1.controller;

import com.kei.tliaswebmanagement1.pojo.Emp;
import com.kei.tliaswebmanagement1.pojo.EmpQueryParam;
import com.kei.tliaswebmanagement1.pojo.PageResult;
import com.kei.tliaswebmanagement1.pojo.Result;
import com.kei.tliaswebmanagement1.service.EmpService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/* 员工管理的Controller*/
//@Slf4j
/* 将公用请求路径提到类上*/
@RequestMapping("/emps")
@RestController
public class EmpController {
    /* 声明日志记录器*/
    private static final Logger log = LoggerFactory.getLogger(EmpController.class);

    /* 注入Service*/
    @Autowired
    private EmpService empService;

    /* ------------------------------分页查询-------------------------------*/

    // @RequestParam(defaultValue = "n")指定请求参数的默认值
//    @GetMapping
//    public Result page(@RequestParam(defaultValue = "1") Integer page,
//                       @RequestParam(defaultValue = "10") Integer pageSize,
//                       // 加入条件查询参数
//                       String name , Integer gender ,
//                       // 规定日期传参格式
//                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin ,
//                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end){
//        log.info("分页查询：起始页码{}，每页展示数{}，查询姓名{}，查询性别{}，查询入职范围{}-{}",
//                 page,pageSize,name,gender,begin,end);
//        /* 原始分页查询*/
////        PageResult<Emp> pageResult = empService.page(page,pageSize);
//        /* 基于pageHelper的分页查询*/
//        PageResult<Emp> pageResult = empService.pageByPageHelper(page,pageSize,name,gender,begin,end);
//        return Result.success(pageResult);
//    }

    @GetMapping
    public Result page(EmpQueryParam empQueryParam){
        log.info("分页查询：{}",empQueryParam);
        /* 原始分页查询*/
//        PageResult<Emp> pageResult = empService.page(page,pageSize);
        /* 基于pageHelper的分页查询*/
        PageResult<Emp> pageResult = empService.pageByPageHelper(empQueryParam);
        return Result.success(pageResult);
    }

    /* ----------------------------- 新增员工信息 ----------------------------*/

    @PostMapping
    // @RequestBody将请求体中json格式的数据，转为对应的对象
    public Result save(@RequestBody Emp emp){
        log.info("新增员工信息：{}",emp);
        empService.save(emp);
        return Result.success();
    }

    /* ------------------------------ 删除员工信息 ----------------------------*/

    // 数组接收方式
    //@DeleteMapping
    //public Result delete(Integer[] ids){
    //    log.info("删除员工信息：{}", Arrays.toString(ids));
    //    return Result.success();
    //}

    // List接收方式 - 推荐方式
    @DeleteMapping
    public Result delete(@RequestParam List<Integer> ids){
        log.info("删除员工信息：{}", ids);
        empService.delete(ids);
        return Result.success();
    }

    /* ------------------------根据id查询员工基本信息及其工作经历-----------------------*/

    @GetMapping("/{id}")
    public Result getInfo(@PathVariable Integer id)// @PathVariable注解用于获取路径中的变量
    {
        log.info("根据id查询员工基本信息及其工作经历：{}",id);
        Emp emp = empService.getInfo(id);
        return Result.success(emp);
    }

    /* ----------------------------修改员工基本信息及其工作经历-------------------------*/

    @PutMapping
    public Result update(@RequestBody Emp emp)// @RequestBody注解用于获取请求体中json格式的数据，转为对应的对象
    {
        log.info("修改员工基本信息及其工作经历：{}",emp);
        empService.update(emp);
        return Result.success();
    }

    /* ------------------------查询所有员工---------------------------*/
    @GetMapping("/list")
    public Result list(){
        log.info("查询所有员工");
        List<Emp> list = empService.list();
        return Result.success(list);
    }







}
