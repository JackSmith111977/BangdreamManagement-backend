package com.kei.tliaswebmanagement1.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class ClazzsQueryParam {
    private String name;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate begin;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate end;
    private Integer page = 1;
    private Integer pageSize = 10;

    /* 构造函数*/
    public ClazzsQueryParam(String name, LocalDate begin, LocalDate end, Integer page, Integer pageSize) {
        this.name = name;
        this.begin = begin;
        this.end = end;
        this.page = page;
        this.pageSize = pageSize;
    }

    /* Getter and Setter*/
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBegin() {
        return begin;
    }

    public void setBegin(LocalDate begin) {
        this.begin = begin;
    }

    public LocalDate getEnd() {
        return end;
    }

    public void setEnd(LocalDate end) {
        this.end = end;
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

    /* toString*/
    @Override
    public String toString() {
        return "ClazzsQueryParam{" +
                "name='" + name + '\'' +
                ", begin=" + begin +
                ", end=" + end +
                ", page=" + page +
                ", pageSize=" + pageSize +
                '}';
    }
}
