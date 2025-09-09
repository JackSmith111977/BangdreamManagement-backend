package com.kei.tliaswebmanagement1.service;


import com.kei.tliaswebmanagement1.pojo.Emp;
import com.kei.tliaswebmanagement1.pojo.EmpQueryParam;
import com.kei.tliaswebmanagement1.pojo.LoginInfo;
import com.kei.tliaswebmanagement1.pojo.PageResult;

import java.util.List;

public interface EmpService {


    /* 分页查询*/
    //page 起始页码
    //pageSize 每页展示数
    //-------------------------------- 原始分页查询 --------------------------------
    PageResult<Emp> page(Integer page, Integer pageSize);

    //-------------------------------- 基于pageHelper的分页查询 --------------------------------
    //PageResult<Emp> pageByPageHelper(Integer page, Integer pageSize, String name, Integer gender, LocalDate begin, LocalDate end);
    PageResult<Emp> pageByPageHelper(EmpQueryParam empQueryParam);

    /* 新增员工信息*/
    void save(Emp emp);

    /* 删除员工信息*/
    void delete(List<Integer> ids);

    /* 查询员工信息*/
    Emp getInfo(Integer id);

    void update(Emp emp);

    /* 查询所有员工*/
    List<Emp> list();

    /* 登录*/
    LoginInfo login(Emp emp);
}
