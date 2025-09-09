package com.kei.tliaswebmanagement1.service.Impl;

import com.kei.tliaswebmanagement1.mapper.EmpMapper;
import com.kei.tliaswebmanagement1.mapper.StudentMapper;
import com.kei.tliaswebmanagement1.pojo.JobOption;
import com.kei.tliaswebmanagement1.pojo.StudentCountData;
import com.kei.tliaswebmanagement1.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ReportServiceImpl implements ReportService {

    /* 注入Mapper*/
    @Autowired
    private EmpMapper empMapper;
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public JobOption getEmpJobData() {
        // 1.调用Mapper接口
        List<Map<String, Object>> list = empMapper.countEmpJobData();// 返回的list中每个map的key是列名，value是列值

        // 2.组装结果并返回
        List<Object> jobList = list.stream().map(map -> map.get("job")).toList();
        List<Object> numList = list.stream().map(map -> map.get("num")).toList();

        return new JobOption(jobList, numList);

    }

    @Override
    public List<Map<String, Object>> getEmpGenderData() {
        // 1.调用Mapper接口

        // 2.返回结果
        return empMapper.getEmpGenderData();
    }

    @Override
    public StudentCountData getClazzStudentCount() {

        List<Map<String, Object>> classIdList = studentMapper.getClazzStudentCount();

        List<Object> clazzNameList = classIdList.stream().map(map -> map.get("class")).toList();
        List<Object> studentCountList = classIdList.stream().map(map -> map.get("data")).toList();
        return new StudentCountData(clazzNameList, studentCountList);

    }

    /* 学员学历统计*/
    @Override
    public List<Map<String, Object>> getStudentDegreeData() {

        List<Map<String, Object>> degreeList = studentMapper.getStudentDegreeData();
        return degreeList;
    }
}
