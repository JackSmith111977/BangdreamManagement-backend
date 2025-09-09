package com.kei.tliaswebmanagement1.controller;

import com.kei.tliaswebmanagement1.pojo.Clazz;
import com.kei.tliaswebmanagement1.pojo.ClazzsQueryParam;
import com.kei.tliaswebmanagement1.pojo.PageResult;
import com.kei.tliaswebmanagement1.pojo.Result;
import com.kei.tliaswebmanagement1.service.ClazzsService;
import com.kei.tliaswebmanagement1.service.EmpService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/clazzs")
@RestController
public class ClazzsController {
    /* 声明日志记录器*/
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(ClazzsController.class.getName());

    /* 注入Service*/
    @Autowired
    private ClazzsService clazzsService;
    @Autowired
    private EmpService empService;

    /* 班级列表查询*/
    @GetMapping
    public Result list(ClazzsQueryParam clazzsQueryParam) {
        logger.info("查询班级列表:"+clazzsQueryParam);
        PageResult<Clazz> data = clazzsService.list(clazzsQueryParam);
        return Result.success(data);
    }

    /* 根据id删除班级*/
    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable Integer id){

        logger.info("根据id删除班级:"+id);
        clazzsService.deleteById(id);
        return Result.success();
    }

    /* 添加班级*/
    @PostMapping
    public Result add(@RequestBody Clazz clazz){
        logger.info("添加班级:"+clazz);
        clazzsService.add(clazz);
        return Result.success();
    }

    /* 根据id查询班级*/
    @GetMapping("/{id}")
    public Result getInfo(@PathVariable Integer id){

        logger.info("根据id查询班级:"+id);
        Clazz clazz = clazzsService.getInfo(id);
        return Result.success(clazz);
    }

    /* 修改班级*/
    @PutMapping
    public Result update(@RequestBody Clazz clazz){
        logger.info("修改班级:"+clazz);
        clazzsService.update(clazz);
        return Result.success();

    }

    /* 查询所有班级*/
    @GetMapping("/list")
    public Result listAll(){
        logger.info("查询所有班级");
        List<Clazz> list = clazzsService.listAll();
        return Result.success(list);
    }




}
