package com.kei.tliaswebmanagement1.service.Impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.kei.tliaswebmanagement1.anno.LogOperation;
import com.kei.tliaswebmanagement1.mapper.ClazzsMapper;
import com.kei.tliaswebmanagement1.mapper.EmpMapper;
import com.kei.tliaswebmanagement1.pojo.Clazz;
import com.kei.tliaswebmanagement1.pojo.ClazzsQueryParam;
import com.kei.tliaswebmanagement1.pojo.PageResult;
import com.kei.tliaswebmanagement1.service.ClazzsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ClazzsServiceImpl implements ClazzsService {
    /* 注入Mapper*/
    @Autowired
    private ClazzsMapper clazzsMapper;
    @Autowired
    private EmpMapper empMapper;


    /* 班级列表查询*/
    @LogOperation
    @Override
    public PageResult<Clazz> list(ClazzsQueryParam clazzsQueryParam) {

        // 1.设置分页查询

        PageHelper.startPage(clazzsQueryParam.getPage(),clazzsQueryParam.getPageSize());

        // 2.执行查询

        List<Clazz> list = clazzsMapper.selectByClazzsQueryParam(clazzsQueryParam);
        list.forEach(clazz -> {
            clazz.setMasterName(empMapper.selectMasterNameById(clazz.getMasterId()));
            if (clazz.getBeginDate().isAfter(LocalDate.now())){
                clazz.setStatus("未开班");
            } else if (clazz.getEndDate().isBefore(LocalDate.now())) {
                clazz.setStatus("已结课");
            }else {
                clazz.setStatus("在读中");
            }
        });
        Page<Clazz> clazzPage = (Page<Clazz>) list;

        // 3.解析查询结果并封装

        return new PageResult<>(clazzPage.getTotal(), clazzPage.getResult());
    }

    /* 根据id删除班级*/
    @LogOperation
    @Override
    public void deleteById(Integer id) {
        clazzsMapper.deleteById(id);
    }

    @Override
    public void add(Clazz clazz) {

        // 处理数据
        clazz.setCreateTime(LocalDateTime.now());
        clazz.setUpdateTime(LocalDateTime.now());

        // 调用Mapper
        clazzsMapper.insert(clazz);
    }

    @Override
    public Clazz getInfo(Integer id) {
        Clazz clazz = clazzsMapper.getInfo(id);
        return clazz;
    }

    @Override
    public void update(Clazz clazz) {
        // 处理数据
        clazz.setUpdateTime(LocalDateTime.now());
        // 调用Mapper
        clazzsMapper.update(clazz);
    }

    /* 查询所有班级*/
    @Override
    public List<Clazz> listAll() {
        List<Clazz> list = clazzsMapper.listAll();
        // 处理数据
        list.forEach(clazz -> {
            LocalDate now = LocalDate.now();
            // 计算是否解散状态status
            if(clazz.getBeginDate().isAfter(now)){
                clazz.setStatus("1");
            } else if (clazz.getBeginDate().isBefore(now) && clazz.getEndDate().isAfter(now)) {
                clazz.setStatus("2");
            }else {
                clazz.setStatus("3");
            }
        });
        return list;
    }
}
