package com.kei.tliaswebmanagement1.utils;

public class CurrentHolder {

    // 线程工具类

    private static final ThreadLocal<Integer> CURRENT_LOCAL = new ThreadLocal<>();

    public static void setCurrentLocal(Integer id) {
        CURRENT_LOCAL.set(id);
    }

    public static Integer getCurrentLocal() {
        return CURRENT_LOCAL.get();
    }

    public static void removeCurrentLocal() {
        CURRENT_LOCAL.remove();
    }
}
