package com.kei.tliaswebmanagement1.utils;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportSelector implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{"com.kei.example1","com.kei.example2","..."};// 返回需要导入的类
    }
}
