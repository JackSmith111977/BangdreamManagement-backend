package com.kei.tliaswebmanagement1.controller;

import com.kei.tliaswebmanagement1.pojo.JobOption;
import com.kei.tliaswebmanagement1.pojo.Result;
import com.kei.tliaswebmanagement1.pojo.StudentCountData;
import com.kei.tliaswebmanagement1.service.ReportService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;


@RequestMapping("/report")
@RestController
public class ReportController {
    /* 声明日志记录器*/
    private static final org.slf4j.Logger log = LoggerFactory.getLogger(ReportController.class.getName());

    /* 注入Service*/
    @Autowired
    private ReportService reportService;

    /* 统计员工职位数据*/
    @GetMapping("/empJobData")
    public Result getEmpJobData(){

        log.info("统计员工职位数据");
        JobOption jobOption = reportService.getEmpJobData();
        return Result.success(jobOption);
    }

    /* 统计员工性别数据*/
    @GetMapping("/empGenderData")
    public Result getEmpGenderData(){
        log.info("统计员工性别数据");
        List<Map<String, Object>> genderList = reportService.getEmpGenderData();
        return Result.success(genderList);
    }

    /* 统计班级人数*/
    @GetMapping("/studentCountData")
    public Result getClazzStudentCount(){
        log.info("统计班级人数");
        StudentCountData studentCountData = reportService.getClazzStudentCount();
        return Result.success(studentCountData);
    }

    /* 学员学历统计*/
    @GetMapping("/studentDegreeData")
    public Result getStudentDegreeData(){
        log.info("学员学历统计");
        List<Map<String, Object>> degreeList = reportService.getStudentDegreeData();
        return Result.success(degreeList);
    }

}
