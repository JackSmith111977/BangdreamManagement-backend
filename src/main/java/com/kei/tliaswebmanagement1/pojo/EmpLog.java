package com.kei.tliaswebmanagement1.pojo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class EmpLog {
    private Integer id;
    private LocalDateTime operateTime;
    private String info;

    public EmpLog(LocalDateTime operateTime, String info) {
        this.operateTime = operateTime;
        this.info = info;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(LocalDateTime operateTime) {
        this.operateTime = operateTime;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
