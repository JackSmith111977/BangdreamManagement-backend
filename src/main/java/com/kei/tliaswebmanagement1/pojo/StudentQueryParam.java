package com.kei.tliaswebmanagement1.pojo;

public class StudentQueryParam {
    private String name;
    private Integer degree;
    private Integer clazzId;
    private Integer page=1;
    private Integer pageSize=10;

    public StudentQueryParam(String name, Integer degree, Integer clazzId, Integer page, Integer pageSize) {
        this.name = name;
        this.degree = degree;
        this.clazzId = clazzId;
        this.page = page;
        this.pageSize = pageSize;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDegree() {
        return degree;
    }

    public void setDegree(Integer degree) {
        this.degree = degree;
    }

    public Integer getClazzId() {
        return clazzId;
    }

    public void setClazzId(Integer clazzId) {
        this.clazzId = clazzId;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        return "StudentQueryParam{" +
                "name='" + name + '\'' +
                ", degree=" + degree +
                ", clazzId=" + clazzId +
                ", page=" + page +
                ", pageSize=" + pageSize +
                '}';
    }
}
