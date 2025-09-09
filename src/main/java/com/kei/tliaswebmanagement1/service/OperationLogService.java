package com.kei.tliaswebmanagement1.service;

import com.kei.tliaswebmanagement1.pojo.OperateLog;
import com.kei.tliaswebmanagement1.pojo.PageResult;

public interface OperationLogService {
    PageResult<OperateLog> list(Integer page, Integer pageSize);
}
