package com.kei.tliaswebmanagement1.service;

import com.kei.tliaswebmanagement1.pojo.JobOption;
import com.kei.tliaswebmanagement1.pojo.StudentCountData;

import java.util.List;
import java.util.Map;

public interface ReportService {
    JobOption getEmpJobData();

    List<Map<String, Object>> getEmpGenderData();

    StudentCountData getClazzStudentCount();

    List<Map<String, Object>> getStudentDegreeData();
}
