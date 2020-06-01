package com.jeekite.online.pojo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.lang.String;
/****
 * @Author:shenkunlin
 * @Description:SysGenerator构建
 * @Date 2019/6/14 19:13
 *****/
@ApiModel(description = "SysGenerator",value = "SysGenerator")
@Table(name="sys_generator")
public class SysGenerator implements Serializable{

	@ApiModelProperty(value = "ID",required = false)
	@Id
    @Column(name = "id")
	private String id;//ID

	@ApiModelProperty(value = "表名",required = false)
    @Column(name = "table_name")
	private String tableName;//表名

	@ApiModelProperty(value = "菜单名称",required = false)
    @Column(name = "menu_name")
	private String menuName;//菜单名称

	@ApiModelProperty(value = "上级菜单",required = false)
    @Column(name = "pid")
	private String pid;//上级菜单

	@ApiModelProperty(value = "上次生成时间",required = false)
    @Column(name = "gen_time")
	private Date genTime;//上次生成时间



	//get方法
	public String getId() {
		return id;
	}

	//set方法
	public void setId(String id) {
		this.id = id;
	}
	//get方法
	public String getTableName() {
		return tableName;
	}

	//set方法
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	//get方法
	public String getMenuName() {
		return menuName;
	}

	//set方法
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	//get方法
	public String getPid() {
		return pid;
	}

	//set方法
	public void setPid(String pid) {
		this.pid = pid;
	}
	//get方法
	public Date getGenTime() {
		return genTime;
	}

	//set方法
	public void setGenTime(Date genTime) {
		this.genTime = genTime;
	}


}
