package com.kei.tliaswebmanagement1.service.Impl;

import com.kei.tliaswebmanagement1.mapper.DeptMapper;
import com.kei.tliaswebmanagement1.pojo.Dept;
import com.kei.tliaswebmanagement1.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;

    @Override
    public List<Dept> findAll() {
        return deptMapper.findAll();
    }

    public void deleteById(Integer id){
        deptMapper.deleteById(id);
    }

    public void add(Dept dept){
        //1.补全创建时间、更新时间
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.insert(dept);
    }

    public Dept getInfo(Integer deptId){
        Dept dept = deptMapper.getInfo(deptId);
        return dept;
    }

    public void update(Dept dept){
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.update(dept);
    }
}
