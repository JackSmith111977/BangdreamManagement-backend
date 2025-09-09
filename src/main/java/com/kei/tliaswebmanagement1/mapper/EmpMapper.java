package com.kei.tliaswebmanagement1.mapper;

import com.kei.tliaswebmanagement1.pojo.Emp;
import com.kei.tliaswebmanagement1.pojo.EmpQueryParam;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/* 员工信息*/
@Mapper
public interface EmpMapper {

//--------------------------------- 原始分页查询 ------------------------------------------------------------------------------------------------------------------------------------

    /* 查询符合条件的记录数*/
    @Select("select count(*) from tlias.emp left join tlias.dept on emp.dept_id = dept.id")
    public long count();

    /* 分页查询*/
    @Select("select emp.id, username, password, emp.name, gender, phone, job, salary, image, entry_date ,emp.create_time, emp.update_time, dept.name deptName, dept_id "+
            "from tlias.emp left join dept on emp.dept_id = dept.id "+
            "order by update_time desc limit #{start},#{pageSize};")
    public List<Emp> list(Integer start, Integer pageSize);


//-------------------------------- 基于pageHelper的分页查询------------------------------------------------------------------------------------------------------------------------------------

    /* 基于注解的SQL语句*/
//    @Select("select emp.id, username, password, emp.name, gender, phone, job, salary, image, entry_date, emp.create_time, emp.update_time, dept_id, dept.name deptName "+
//            "from tlias.emp left join tlias.dept on emp.dept_id = dept.id "+
//            "where emp.name like '%'+#{name}+'%' and emp.gender=#{gender} and emp.entry_date between #{begin} and #{end} "+
//            "order by update_time desc ")
    /* 基于xml映射实现SQL语句*/
    public List<Emp> listByPageHelper(EmpQueryParam empQueryParam);


    /* 新增员工信息*/
    // 利用主键返回，将生成的主键与empExpr对象关联
    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into emp (username, name, gender, phone, job, salary, image, entry_date, create_time, update_time, dept_id) " +
            "                 values " +
            "                (#{username},#{name},#{gender},#{phone},#{job},#{salary},#{image},#{entryDate},#{createTime},#{updateTime},#{deptId})")
    void insert(Emp emp);

    /* 删除员工信息*/
    void deleteByIds(List<Integer> ids);


    /* 根据id查询员工信息*/
    Emp getInfo(Integer id);

    /* 根据id修改员工信息*/
    // @Update("update emp set username=#{username},name=#{name},gender=#{gender},phone=#{phone},job=#{job},salary=#{salary},image=#{image},entry_date=#{entryDate},update_time=#{updateTime},dept_id=#{deptId} where id=#{id}")
    void updateById(Emp emp);

    /* 统计员工职位的人数*/
    List<Map<String, Object>> countEmpJobData();

    /* 统计员工性别信息*/
    List<Map<String, Object>> getEmpGenderData();

    /* 根据id查找教师名字*/
    @Select("select name from emp where id=#{masterId}")
    String selectMasterNameById(Integer masterId);


    /* 查询所有员工信息*/
    @Select("select id, username, password, name, gender, phone, job, salary, image, entry_date, create_time, update_time, dept_id from emp")
    List<Emp> listAll();

    /* 根据用户名和密码查询员工信息*/
    @Select("SELECT id, username, password, name, gender, phone, job, salary, image, entry_date, create_time, update_time, dept_id from emp where username=#{username} and password=#{password}")
    Emp selectByUsernameAndPassword(Emp emp);
}
