package com.jeekite.online.build;

import java.util.Map;

/****
 * @Author:dudianlong
 * @Description:Dao构建
 * @Date 2020/5/14 23:21
 *****/
public class DaoBuilder {


    /***
     * 构建Dao
     * @param modelMap
     */
    public static void builder(Map<String,Object> modelMap){
        //生成Dao层文件
        BuilderFactory.builder(modelMap,
                "/template/mapper",
                "Mapper.java",
                TemplateBuilder.PACKAGE_MAPPER,
                "Mapper.java");
    }

}
