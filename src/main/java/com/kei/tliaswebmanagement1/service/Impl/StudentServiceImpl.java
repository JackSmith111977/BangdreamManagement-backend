package com.kei.tliaswebmanagement1.service.Impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.kei.tliaswebmanagement1.mapper.StudentMapper;
import com.kei.tliaswebmanagement1.pojo.PageResult;
import com.kei.tliaswebmanagement1.pojo.Student;
import com.kei.tliaswebmanagement1.pojo.StudentQueryParam;
import com.kei.tliaswebmanagement1.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    /* 注入Mapper*/
    @Autowired
    private StudentMapper studentMapper;



    /* 学员列表查询*/
    @Override
    public PageResult<Student> list(StudentQueryParam studentQueryParam) {
        // PageHelper
        PageHelper.startPage(studentQueryParam.getPage(),studentQueryParam.getPageSize());

        // 执行查询,返回List
        List<Student> data = studentMapper.select(studentQueryParam);
        // 查询班级名称
        data.forEach(student -> student.setClazzName(studentMapper.selectClazzNameById(student.getClazzId())));

        // 强制转换成Page
        Page<Student> page = (Page<Student>) data;

        // PageResult封装分页结果并返回
        return new PageResult<>(page.getTotal(), page.getResult());
    }


    /* 添加学员*/
    @Override
    public void add(Student student) {
        // 数据处理
        student.setCreateTime(LocalDateTime.now());
        student.setUpdateTime(LocalDateTime.now());
        // 调用Mapper
        studentMapper.insert(student);

    }

    /* 根据id查找学员*/
    @Override
    public Student getInfo(Integer id) {
        // 调用Mapper
        Student student = studentMapper.selectById(id);
        // 查询班级名称
        student.setClazzName(studentMapper.selectClazzNameById(student.getClazzId()));
        return student;
    }

    /* 修改学员信息*/
    @Override
    public void update(Student student) {
        // 数据处理
        student.setUpdateTime(LocalDateTime.now());
        // 调用Mapper
        studentMapper.update(student);


    }

    /* 根据id删除学生信息*/
    @Override
    public void delete(List<Integer> ids) {
        ids.forEach(id -> studentMapper.deleteById(id));
    }

    /* 根据id进行学员的违纪处理*/
    @Override
    public void handleViolation(Integer id, Integer score) {
        // 调用Mapper
        LocalDateTime now = LocalDateTime.now();
        studentMapper.handleViolation(id,score,now);
    }

}
