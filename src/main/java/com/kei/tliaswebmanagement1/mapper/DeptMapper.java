package com.kei.tliaswebmanagement1.mapper;

import com.kei.tliaswebmanagement1.pojo.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;


/* Dao/Mapper: 数据访问操作（增删改查）*/
@Mapper
public interface DeptMapper {

    /* 查询所有的乐队数据*/
    //由于MyBatis不会对查询结果与实例中命名不同的字段进行映射，因此需要手动封装
    //方式一：使用@Results注解手动封装
//    @Results({
//            @Result(column = "create_time" , property = "createTime"),
//            @Result(column = "update_time" , property = "updateTime")
//    })
    //方式二：起别名
//    @Select("select id, name, create_time createTime, update_time updateTime from dept order by update_time desc ")
    //方式三：在application.yml中配置驼峰命名法
    @Select("select id, name, create_time, update_time from dept order by update_time desc ")
    List<Dept> findAll();

    /* 根据id删除乐队*/
    @Delete("delete from dept where id = #{id}")
    void deleteById(Integer id);

    /* 添加乐队*/
    @Insert("insert into dept (name, create_time, update_time) values (#{name},#{createTime},#{updateTime})")
    void insert(Dept dept);

    /* 根据id查询乐队*/
    @Select("select id, name, create_time, update_time from dept where id=#{deptId}")
    Dept getInfo(Integer deptId);

    /* 更新乐队*/
    @Update("update dept set name = #{name},update_time = #{updateTime} where id = #{id} ")
    void update(Dept dept);
}
