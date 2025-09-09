package com.kei.tliaswebmanagement1.controller;


import com.kei.tliaswebmanagement1.pojo.PageResult;
import com.kei.tliaswebmanagement1.pojo.Result;
import com.kei.tliaswebmanagement1.pojo.Student;
import com.kei.tliaswebmanagement1.pojo.StudentQueryParam;
import com.kei.tliaswebmanagement1.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/students")
@RestController
public class StudentController {
    /* 声明日志记录器*/
    private static final Logger log = LoggerFactory.getLogger(StudentController.class.getName());

    /* 注入Service*/
    @Autowired
    private StudentService studentService;

    /* 学员列表查询*/
    @GetMapping
    public Result list(StudentQueryParam studentQueryParam){
        log.info("查询学员列表"+studentQueryParam);
        PageResult<Student> data = studentService.list(studentQueryParam);
        return Result.success(data);
    }

    /* 添加学员*/
    @PostMapping
    public Result add(@RequestBody Student student){
        log.info("添加学员"+student);
        studentService.add(student);
        return Result.success();
    }

    /* 根据id查找学员*/
    @GetMapping("/{id}")
    public Result getInfo(@PathVariable Integer id){
        log.info("根据id查找学员"+id);
        Student student = studentService.getInfo(id);
        return Result.success(student);
    }

    /* 修改学员信息*/
    @PutMapping
    public Result update(@RequestBody Student student){
        log.info("修改学员信息"+student);
        studentService.update(student);
        return Result.success();
    }

    /* 根据id删除学员信息*/
    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable List<Integer> ids){
        log.info("根据id删除学员信息"+ids);
        studentService.delete(ids);
        return Result.success();
    }

    /* 根据id进行学员的违纪处理*/
    @PutMapping("/violation/{id}/{score}")
    public Result handleViolation(@PathVariable("id") Integer id,@PathVariable("score") Integer score){
        log.info("根据id进行学员的违纪处理"+id+score);
        studentService.handleViolation(id,score);
        return Result.success();
    }
}
