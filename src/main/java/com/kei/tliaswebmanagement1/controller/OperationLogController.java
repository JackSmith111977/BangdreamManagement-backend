package com.kei.tliaswebmanagement1.controller;

import com.kei.tliaswebmanagement1.pojo.OperateLog;
import com.kei.tliaswebmanagement1.pojo.OperateLogQueryParam;
import com.kei.tliaswebmanagement1.pojo.PageResult;
import com.kei.tliaswebmanagement1.pojo.Result;
import com.kei.tliaswebmanagement1.service.OperationLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/log/page")
@RestController
public class OperationLogController {

    /* 注入Service*/
    @Autowired
    private OperationLogService operationLogService;


    @GetMapping
    public Result list(OperateLogQueryParam operateLogQueryParam){
        PageResult<OperateLog> result = operationLogService.list(operateLogQueryParam.getPage(),operateLogQueryParam.getPageSize());
        return Result.success(result);


    }
}
