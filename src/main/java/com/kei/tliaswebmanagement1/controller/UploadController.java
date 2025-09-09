package com.kei.tliaswebmanagement1.controller;


import com.kei.tliaswebmanagement1.pojo.Result;
import com.kei.tliaswebmanagement1.utils.AliyunOSSOperator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class UploadController {

    /* 声明日志记录器*/
    private static final Logger log = LoggerFactory.getLogger(EmpController.class);


    /* ------------------------本地磁盘储存方案-----------------------*/

    //@PostMapping("/upload")
    //public Result upload(String name, Integer age, MultipartFile file){
    //    log.info("文件上传：{}，{}，{}",name,age,file);// 接收的文件存放于临时目录中，接收结束后会被删除
    //    /* 文件上传处理*/
    //
    //    // 获取原文件名
    //    String originalFilename = file.getOriginalFilename();
    //    // 截取文件类型
    //    String fileType = originalFilename.substring(originalFilename.lastIndexOf("."));
    //    // 利用uuid生成唯一文件名
    //    String fileName = UUID.randomUUID().toString()+fileType;
    //
    //    // 保存文件-本地保存
    //    try {
    //        file.transferTo(new File("F:/ReceiveFiles/"+fileName));
    //    } catch (IOException e) {
    //        throw new RuntimeException(e);
    //    }
    //
    //    return Result.success();
    //}

    /* ------------------------阿里云OSS储存方案-----------------------*/

    //注入阿里云OSS工具类
    @Autowired
    private AliyunOSSOperator aliyunOSSOperator;

    @PostMapping("/upload")
    public Result upload(MultipartFile file){

        log.info("文件上传：{}",file.getOriginalFilename());

        //调用阿里云工具类进行文件上传
        try {
            String url = aliyunOSSOperator.upload(file.getBytes(), file.getOriginalFilename());
            log.info("文件上传：{}",url);
            return Result.success(url);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }



}
