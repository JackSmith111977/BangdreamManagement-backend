package com.kei.tliaswebmanagement1.mapper;

import com.kei.tliaswebmanagement1.pojo.EmpExpr;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/* 工作经历*/
@Mapper
public interface EmpExprMapper {

    /* 批量保存员工的工作经历*/
    void insertBatch(List<EmpExpr> exprList);

    /* 批量删除员工的工作经历*/
    void deleteByEmpIds(List<Integer> empIds);
}
