package com.kei.tliaswebmanagement1.aop;

import com.kei.tliaswebmanagement1.mapper.OperateLogMapper;
import com.kei.tliaswebmanagement1.pojo.OperateLog;
import com.kei.tliaswebmanagement1.utils.CurrentHolder;
import lombok.SneakyThrows;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.util.Arrays;


@Aspect
@Component
public class OperateLogAspect {

    private static final Logger log = LoggerFactory.getLogger(OperateLogAspect.class);

    // 注入Mapper
    @Autowired
    private OperateLogMapper operateLogMapper;

    private Integer getEmpId(){

        Integer empId = CurrentHolder.getCurrentLocal();
        return empId;
    }





    @Around("@annotation(com.kei.tliaswebmanagement1.anno.Log)")
    public Object operateLog(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        long startTime = System.currentTimeMillis();


        Object result = proceedingJoinPoint.proceed();

        long endTime = System.currentTimeMillis();
        long costTime = endTime - startTime;
        // 获取类参数
        OperateLog operateLog = new OperateLog();
        operateLog.setOperateEmpId(getEmpId());//根据登录用户获取
        operateLog.setCostTime(costTime);
        operateLog.setOperateTime(LocalDateTime.now());
        operateLog.setClassName(proceedingJoinPoint.getTarget().getClass().getName());
        operateLog.setMethodName(proceedingJoinPoint.getSignature().getName());
        operateLog.setMethodParams(Arrays.toString(proceedingJoinPoint.getArgs()));
        operateLog.setReturnValue(result != null?result.toString() : "void");

        // 调用Mapper
        log.info("operateLog:{}",operateLog);
        operateLogMapper.insertOperateLog(operateLog);

        return result;

    }

}
