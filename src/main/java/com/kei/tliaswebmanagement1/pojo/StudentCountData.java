package com.kei.tliaswebmanagement1.pojo;

import java.util.List;

public class StudentCountData {
    private List clazzList;
    private List dataList;

    public StudentCountData(List clazzList, List dataList) {
        this.clazzList = clazzList;
        this.dataList = dataList;
    }

    public List getClazzList() {
        return clazzList;
    }

    public void setClazzList(List clazzList) {
        this.clazzList = clazzList;
    }

    public List getDataList() {
        return dataList;
    }

    public void setDataList(List dataList) {
        this.dataList = dataList;
    }

    @Override
    public String toString() {
        return "StudentCountData{" +
                "classList=" + clazzList +
                ", dataList=" + dataList +
                '}';
    }
}
