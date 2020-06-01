package com.jeekite.online.swagger;

import java.util.List;

/*****
 * @Author: dudianlong
 * @Date: 2020/5/23 14:25
 * @Description: com.jeekite.online
 ****/
public class SwaggerPath {

    //请求路径
    private String path;

    //方法配置
    private List<SwaggerMethod> methods;

    //对象
    private String model;

    //对象-首字母小写
    private String table;

    public SwaggerPath(String Table, String table) {
        this.model = Table;
        this.table = table;
    }

    public SwaggerPath() {
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public List<SwaggerMethod> getMethods() {
        return methods;
    }

    public void setMethods(List<SwaggerMethod> methods) {
        this.methods = methods;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }
}
