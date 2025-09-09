package com.kei.tliaswebmanagement1.mapper;

import com.kei.tliaswebmanagement1.pojo.Student;
import com.kei.tliaswebmanagement1.pojo.StudentQueryParam;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Mapper
public interface StudentMapper {


    /* 学员列表查询*/
    List<Student> select(StudentQueryParam studentQueryParam);

    /* 查询班级名称*/
    @Select("select name from tlias.class where id=#{classId}")
    String selectClazzNameById(Integer clazzId);

    /* 添加学员*/
    void insert(Student student);

    /* 根据id查找学员*/
    @Select("select id, name, no, gender, phone, id_card, is_college, address, degree, graduation_date, clazz_id, violation_count, violation_score, create_time, update_time from tlias.student where id=#{id}")
    Student selectById(Integer id);

    /* 修改学员信息*/
    void update(Student student);

    /* 根据id删除学员信息*/
    @Delete("delete from tlias.student where id=#{id}")
    void deleteById(Integer id);

    /* 违纪处理*/
    void handleViolation(Integer id, Integer score, LocalDateTime now);

    /* 统计班级人数*/
    List<Map<String, Object>> getClazzStudentCount();

    /* 学员学历统计*/
    List<Map<String, Object>> getStudentDegreeData();
}
