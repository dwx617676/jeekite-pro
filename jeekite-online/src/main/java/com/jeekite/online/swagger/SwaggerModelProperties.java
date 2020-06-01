package com.jeekite.online.swagger;

/*****
 * @Author: dudianlong
 * @Date: 2020/5/23 14:25
 * @Description: com.jeekite.online
 ****/
public class SwaggerModelProperties {

    //属性名字
    private String name;

    //类型
    private String type;

    //格式
    private String format;

    //描述
    private String description;

    public SwaggerModelProperties() {
    }

    public SwaggerModelProperties(String name, String type, String format, String description) {
        this.name = name;
        this.type = type;
        this.format = format;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
