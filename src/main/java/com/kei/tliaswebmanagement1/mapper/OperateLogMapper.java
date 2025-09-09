package com.kei.tliaswebmanagement1.mapper;

import com.kei.tliaswebmanagement1.pojo.OperateLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface OperateLogMapper {

    @Insert("insert into tlias.operate_log (operate_emp_id, operate_time, class_name, method_name, method_params, return_value, cost_time)" +
            "values (#{operateEmpId},#{operateTime},#{className},#{methodName},#{methodParams},#{returnValue},#{costTime})")
    public void insertOperateLog(OperateLog operateLog);

    @Select("SELECT id, operate_emp_id, operate_time, class_name, method_name, method_params, return_value, cost_time from tlias.operate_log")
    List<OperateLog> list();
}
