package com.kei.tliaswebmanagement1.pojo;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class Emp {
    private Integer id;// 主键
    private String username;// 用户名
    private String password;// 密码
    private String name;// 姓名
    private Integer gender;// 性别
    private String phone;// 手机号
    private Integer job;// 职位
    private Integer salary;// 薪资
    private String image;// 头像
    private LocalDate entryDate;// 入职日期
    private Integer deptId;// 关联的部门id
    private LocalDateTime createTime;// 创建时间
    private LocalDateTime updateTime;// 修改时间

    // 封装部门名称
    private String deptName;

    // 封装工作经历信息
    private List<EmpExpr> exprList;

//--------------- getter setter ------------------

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public LocalDate getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(LocalDate entryDate) {
        this.entryDate = entryDate;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Integer getJob() {
        return job;
    }

    public void setJob(Integer job) {
        this.job = job;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<EmpExpr> getExprList() {
        return exprList;
    }

    public void setExprList(List<EmpExpr> exprList) {
        this.exprList = exprList;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", phone='" + phone + '\'' +
                ", job=" + job +
                ", salary=" + salary +
                ", image='" + image + '\'' +
                ", entryDate=" + entryDate +
                ", deptId=" + deptId +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", deptName='" + deptName + '\'' +
                ", exprList=" + exprList +
                '}';
    }
}
