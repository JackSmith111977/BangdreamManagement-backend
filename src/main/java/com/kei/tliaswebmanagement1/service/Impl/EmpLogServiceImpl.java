package com.kei.tliaswebmanagement1.service.Impl;

import com.kei.tliaswebmanagement1.mapper.EmpLogMapper;
import com.kei.tliaswebmanagement1.pojo.EmpLog;
import com.kei.tliaswebmanagement1.service.EmpLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmpLogServiceImpl implements EmpLogService {

    @Autowired
    private EmpLogMapper empLogMapper;

    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = {Exception.class})
    @Override
    public void insertLog(EmpLog empLog){

        empLogMapper.insert(empLog);

    }
}
