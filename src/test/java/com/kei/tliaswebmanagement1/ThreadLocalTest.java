package com.kei.tliaswebmanagement1;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


public class ThreadLocalTest {



    /* 线程局部变量*/
    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    // 主线程
    public static void main(String[] args) {
        // 往线程局部变量中设置值
        threadLocal.set("Main Message");

            // 创建新线程
            new Thread(new Runnable() {
                @Override
                public void run() {
                    // 输出结果为null，无法获得main线程的值，说明当前线程设置的值只能由当前线程获取
                    System.out.println(Thread.currentThread().getName()+':'+threadLocal.get());
                }
            }).start();

        // 获取打印线程局部变量的值
        System.out.println(Thread.currentThread().getName()+':'+threadLocal.get());

        // 移除线程局部变量
        threadLocal.remove();

        System.out.println(Thread.currentThread().getName()+':'+threadLocal.get());
    }





}
