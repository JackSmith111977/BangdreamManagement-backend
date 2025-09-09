package com.kei.tliaswebmanagement1.pojo;


import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/* 分页结果封装类*/
@Data
@NoArgsConstructor
public class PageResult<T> {
    private long total;
    private List<T> rows;

    // 全参构造
    public PageResult(long total , List<T> rows){
        this.total = total;
        this.rows = rows;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
