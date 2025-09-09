package com.kei.tliaswebmanagement1.service.Impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.kei.tliaswebmanagement1.mapper.OperateLogMapper;
import com.kei.tliaswebmanagement1.pojo.OperateLog;
import com.kei.tliaswebmanagement1.pojo.PageResult;
import com.kei.tliaswebmanagement1.service.OperationLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OperationLogServiceImpl implements OperationLogService {

    /* 注入Mapper*/
    @Autowired
    private OperateLogMapper operateLogMapper;



    @Override
    public PageResult<OperateLog> list(Integer page, Integer pageSize) {
        // 1.设置分页参数
        PageHelper.startPage(page,pageSize);

        // 2.执行查询
        List<OperateLog> list = operateLogMapper.list();
        Page<OperateLog> operateLogPage = (Page<OperateLog>) list;


        // 3.解析查询结果并封装
        return new PageResult<>(operateLogPage.getTotal(),operateLogPage.getResult());
    }
}
