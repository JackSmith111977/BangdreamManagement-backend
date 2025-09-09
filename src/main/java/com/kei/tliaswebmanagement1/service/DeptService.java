package com.kei.tliaswebmanagement1.service;

import com.kei.tliaswebmanagement1.pojo.Dept;

import java.util.List;


/* Service: 业务处理*/
public interface DeptService {

    /* 查询所有的乐队数据*/
    List<Dept> findAll();

    /* 根据id删除乐队数据*/
    void deleteById(Integer id);

    /* 添加乐队数据*/
    void add(Dept dept);

    /* 根据id查询乐队数据*/
    Dept getInfo(Integer deptId);

    /* 根据id修改乐队数据*/
    void update(Dept dept);
}
