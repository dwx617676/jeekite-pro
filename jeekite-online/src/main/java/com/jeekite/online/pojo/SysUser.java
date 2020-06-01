package com.jeekite.online.pojo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.*;
import java.io.Serializable;
import java.lang.String;
/****
 * @Author:shenkunlin
 * @Description:SysUser构建
 * @Date 2019/6/14 19:13
 *****/
@ApiModel(description = "SysUser",value = "SysUser")
@Table(name="tb_sys_user")
public class SysUser implements Serializable{

	@ApiModelProperty(value = "主键ID",required = false)
	@Id
    @Column(name = "id")
	private String id;//主键ID

	@ApiModelProperty(value = "用户名",required = false)
    @Column(name = "username")
	private String username;//用户名

	@ApiModelProperty(value = "用户密码",required = false)
    @Column(name = "password")
	private String password;//用户密码



	//get方法
	public String getId() {
		return id;
	}

	//set方法
	public void setId(String id) {
		this.id = id;
	}
	//get方法
	public String getUsername() {
		return username;
	}

	//set方法
	public void setUsername(String username) {
		this.username = username;
	}
	//get方法
	public String getPassword() {
		return password;
	}

	//set方法
	public void setPassword(String password) {
		this.password = password;
	}


}
