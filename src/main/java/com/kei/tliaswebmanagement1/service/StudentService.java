package com.kei.tliaswebmanagement1.service;

import com.kei.tliaswebmanagement1.pojo.PageResult;
import com.kei.tliaswebmanagement1.pojo.Student;
import com.kei.tliaswebmanagement1.pojo.StudentQueryParam;

import java.util.List;

public interface StudentService {

    /* 学员列表查询*/
    PageResult<Student> list(StudentQueryParam studentQueryParam);

    /* 添加学员*/
    void add(Student student);

    /* 根据id查找学员*/
    Student getInfo(Integer id);

    /* 修改学员信息*/
    void update(Student student);

    /* 根据id删除学员信息*/
    void delete(List<Integer> ids);

    /* 根据id进行学员的违纪处理*/
    void handleViolation(Integer id, Integer score);
}
