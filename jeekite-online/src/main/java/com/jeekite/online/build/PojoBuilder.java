package com.jeekite.online.build;

import java.util.Map;

/****
 * @Author:dudianlong
 * @Description:Pojo构建
 * @Date 2020/5/14 23:21
 *****/
public class PojoBuilder {


    /***
     * 构建Pojo
     * @param dataModel
     */
    public static void builder(Map<String,Object> dataModel){
        //生成Pojo层文件
        BuilderFactory.builder(dataModel,
                "/template/entity",
                "Pojo.java",
                TemplateBuilder.PACKAGE_POJO,
                ".java");
    }

}
