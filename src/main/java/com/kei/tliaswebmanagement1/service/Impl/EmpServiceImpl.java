package com.kei.tliaswebmanagement1.service.Impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.kei.tliaswebmanagement1.mapper.EmpExprMapper;
import com.kei.tliaswebmanagement1.mapper.EmpMapper;
import com.kei.tliaswebmanagement1.pojo.*;
import com.kei.tliaswebmanagement1.service.EmpLogService;
import com.kei.tliaswebmanagement1.service.EmpService;
import com.kei.tliaswebmanagement1.utils.JwtUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmpServiceImpl implements EmpService {
    /* 声明日志记录器*/
    private static final Logger log = LoggerFactory.getLogger(EmpServiceImpl.class);


    /* 注入EmpMapper*/
    @Autowired
    private EmpMapper empMapper;

    /* 注入EmpExpr*/
    @Autowired
    private EmpExprMapper empExprMapper;

    /* 注入EmpLogService*/
    @Autowired
    private EmpLogService empLogService;

    //--------------------------- 原始分页查询 ------------------------------------------
    @Override
    public PageResult<Emp> page(Integer page, Integer pageSize) {
        // 1.调用mapper接口，查询总记录数
        long total = empMapper.count();

        // 2.调用mapper接口，查询分页数据,page需要转化成起始索引
        List<Emp> rows = empMapper.list((page-1)*pageSize , pageSize);

        // 3.封装到PageResult对象中

        return new PageResult<Emp>(total,rows);
    }

    //--------------------------- 基于pageHelper分页查询 ------------------------------------------
    /* 注意事项：
    * 1.SQL语句不能加分号
    * 2.PageHelper 仅对紧跟其后的第一个语句进行分页处理*/
//    @Override
//    public PageResult<Emp> pageByPageHelper(Integer page, Integer pageSize , String name, Integer gender, LocalDate begin, LocalDate end){
//        // 1.设置分页参数(pageHelper)
//        PageHelper.startPage(page,pageSize);
//
//        // 2.执行查询
//        List<Emp> list = empMapper.listByPageHelper(name, gender, begin, end);
//
//        Page<Emp> empPage = (Page<Emp>) list;// Page对象封装了分页数据
//
//        // 3.解析查询结果并封装
//        return new PageResult<>(empPage.getTotal(),empPage.getResult());
//    }
    @Override
    public PageResult<Emp> pageByPageHelper(EmpQueryParam empQueryParam) {
        // 1.设置分页参数(pageHelper)
        PageHelper.startPage(empQueryParam.getPage(), empQueryParam.getPageSize());

        // 2.执行查询
        List<Emp> list = empMapper.listByPageHelper(empQueryParam);

        Page<Emp> empPage = (Page<Emp>) list;// Page对象封装了分页数据

        // 3.解析查询结果并封装
        return new PageResult<>(empPage.getTotal(), empPage.getResult());
    }

    /* ----------------------- 新增员工数据 -------------------------- */
    // 保证数据库操作的原子性，进行事务控制
    // 事务控制 @Transactional 可以作用在方法、类和接口上
    // 事务控制 属性rollbackFor可以指定回滚的异常类型，Exception.class表示所有异常类型回滚
    /* 事务控制 属性propagation可以指定事务传播行为
    *   REQUIRED        默认值，需要事务，如果当前存在事务，则加入该事务，否则创建新事务
    *   REQUIRED_NEW    需要新事务，无论有无，总是创建新事务
    *   SUPPORTS        支持事务，如果当前存在事务，则加入该事务，否则不创建新事务
    *   NOT_SUPPORTED   不支持事务，在无事务状态下运行，如果当前存在事务，则挂起当前事务
    *   MANDATORY       必须有事务，如果当前没有事务，则抛出异常
    *   NEVER           必须没事务，否则抛出异常*/
    @Transactional(rollbackFor = {Exception.class} )// 默认只有出现运行级异常RuntimeException会回滚
    @Override
    public void save(Emp emp){
        try {
            // 1.保存员工的基本信息
            emp.setCreateTime(LocalDateTime.now());
            emp.setUpdateTime(LocalDateTime.now());
            empMapper.insert(emp);


            // 2.保存员工的工作经历
            List<EmpExpr> exprList = emp.getExprList();
            if (!CollectionUtils.isEmpty(exprList)){

                // 遍历集合，将获取的主键，设置到每个EmpExpr对象中
                exprList.forEach(empExpr -> {
                    empExpr.setEmpId(emp.getId());
                });

                empExprMapper.insertBatch(exprList);
            }
        } finally {
            // 3.记录操作日志
            EmpLog empLog = new EmpLog(LocalDateTime.now(),"新增员工"+emp);
            empLogService.insertLog(empLog);

        }
    }




    /* ----------------------- 删除员工数据 -------------------------*/

    @Transactional(rollbackFor = {Exception.class})
    @Override
    public void delete(List<Integer> ids){

        // 1.删除员工基本信息
        empMapper.deleteByIds(ids);


        // 2.删除员工工作经历
        empExprMapper.deleteByEmpIds(ids);


    }

    /* ----------------------- 查询员工数据 -------------------------*/
    @Override
    public Emp getInfo(Integer id){
        Emp emp = empMapper.getInfo(id);
        return emp;
    }

    /* ----------------------- 更新员工数据 -------------------------*/

    @Transactional(rollbackFor = {Exception.class})
    @Override
    public void update(Emp emp){
        // 1.根据id更新员工基本信息
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.updateById(emp);


        // 2.根据id更新员工工作经历
        // 2.1 先删除
        empExprMapper.deleteByEmpIds(Arrays.asList(emp.getId()));// 利用之前实例化的方法，需要Arrays.asList()将id转为List集合


        // 2.2 再添加
        List<EmpExpr> empExprList = emp.getExprList();
        if(!CollectionUtils.isEmpty(empExprList)){
            empExprList.forEach(empExpr -> empExpr.setId(emp.getId()));
            empExprMapper.insertBatch(empExprList);
        }
    }

    @Override
    public List<Emp> list() {
        List<Emp> empList = empMapper.listAll();
        return empList;
    }

    /* 登录*/
    @Override
    public LoginInfo login(Emp emp) {
        // 1.调用Mapper，根据用户名和密码查询用户信息
        Emp e = empMapper.selectByUsernameAndPassword(emp);

        // 2.判断是否存在员工，然后组装LoginInfo
        if(e != null){
            log.info("登录成功：{}",e);
            // 生成Jwt令牌
            Map<String, Object> claims = new HashMap<>();
            claims.put("id",e.getId());
            claims.put("username",e.getUsername());
            String token = JwtUtils.generateToken(claims);


            LoginInfo loginInfo = new LoginInfo(e.getId(),e.getUsername(),e.getName(),token,e.getImage());
            return loginInfo;
        }

        // 3.不存在，则返回null
        return null;
    }


}
