package com.jeekite.online.build;

import java.util.Map;

/****
 * @Author:dudianlong
 * @Description:Feign构建
 * @Date 2020/5/14 23:21
 *****/
public class FeignBuilder {


    /***
     * 构建Feign
     * @param modelMap
     */
    public static void builder(Map<String,Object> modelMap){
        //生成Dao层文件
        BuilderFactory.builder(modelMap,
                "/template/feign",
                "Feign.java",
                TemplateBuilder.PACKAGE_FEIGN,
                "Feign.java");
    }

}
