package com.kei.tliaswebmanagement1.pojo;

public class OperateLogQueryParam {
    private Integer page;
    private Integer pageSize;
















    public OperateLogQueryParam(Integer page, Integer pageSize) {
        this.page = page;
        this.pageSize = pageSize;
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
        return "OperateLogQueryParam{" +
                "page=" + page +
                ", pageSize=" + pageSize +
                '}';
    }
}
