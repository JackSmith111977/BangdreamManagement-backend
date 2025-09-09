package com.kei.tliaswebmanagement1.mapper;

import com.kei.tliaswebmanagement1.pojo.Clazz;
import com.kei.tliaswebmanagement1.pojo.ClazzsQueryParam;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ClazzsMapper {

    /* 分页查询班级信息*/
    List<Clazz> selectByClazzsQueryParam(ClazzsQueryParam clazzsQueryParam);

    /* 根据id删除班级*/
    @Delete("DELETE from tlias.class where id=#{id}")
    void deleteById(Integer id);

    /* 添加班级*/
    void insert(Clazz clazz);

    /* 根据id查询班级信息*/
    @Select("select id, name, room, begin_date, end_date, master_id, subject, create_time, update_time from tlias.class where id = #{id}")
    Clazz getInfo(Integer id);

    /* 修改班级*/
    void update(Clazz clazz);


    /* 查询所有班级*/
    @Select("select id, name, room, begin_date, end_date, master_id, subject, create_time, update_time from tlias.class")
    List<Clazz> listAll();
}
