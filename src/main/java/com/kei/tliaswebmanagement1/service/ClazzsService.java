package com.kei.tliaswebmanagement1.service;

import com.kei.tliaswebmanagement1.pojo.Clazz;
import com.kei.tliaswebmanagement1.pojo.ClazzsQueryParam;
import com.kei.tliaswebmanagement1.pojo.PageResult;

import java.util.List;

public interface ClazzsService {

    /* 班级列表查询*/
   PageResult<Clazz> list(ClazzsQueryParam clazzsQueryParam);

    /* 根据id删除班级*/
    void deleteById(Integer id);

    /* 添加班级*/
    void add(Clazz clazz);

    /* 根据id查询班级*/
    Clazz getInfo(Integer id);

    /* 修改班级*/
    void update(Clazz clazz);

    /* 查询所有班级*/
    List<Clazz> listAll();
}
