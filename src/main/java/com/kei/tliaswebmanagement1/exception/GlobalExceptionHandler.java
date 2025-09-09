package com.kei.tliaswebmanagement1.exception;

import com.kei.tliaswebmanagement1.pojo.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/* 全局异常处理器*/
@RestControllerAdvice
public class GlobalExceptionHandler {
    /* 声明日志记录器*/
    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler
    public Result handleException(Exception e){
        log.error("程序出错了喵~",e);
        return Result.error("出错了喵~，请主人灌注程序喵~");
    }

    // 优先调用子类异常
    @ExceptionHandler
    public Result handleDuplicateKeyException(DuplicateKeyException e){

        log.error("程序出错了喵~",e);
        String msg = e.getMessage();
        int i = msg.indexOf("Duplicate entry");// 获取错误信息 indexOf()方法返回指定子字符串在此字符串中第一次出现处的索引。
        String errMsg = msg.substring(i);
        String[] arr = errMsg.split(" ");
        return Result.error(arr[2]+"已存在了喵~请修改喵~");
    }

    /* 班级太长*/
    @ExceptionHandler
    public Result handleMysqlDataTruncationException(DataIntegrityViolationException e){
        log.error("程序出错了喵~",e);
        String msg = e.getMessage();
        int i = msg.indexOf("Data too long for column");
        String errMsg = msg.substring(i);
        String[] arr = errMsg.split(" ");
        return Result.error(arr[5]+"太长了喵~");
    }
}
