package com.kei.tliaswebmanagement1.mapper;

import com.kei.tliaswebmanagement1.pojo.EmpLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmpLogMapper {

    @Insert("insert into tlias.emp_log (operate_time,info) values (#{operateTime},#{info})")
    public void insert(EmpLog empLog);
}
