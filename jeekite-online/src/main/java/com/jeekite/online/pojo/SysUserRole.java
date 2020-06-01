package com.jeekite.online.pojo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.lang.String;
/****
 * @Author:shenkunlin
 * @Description:SysUserRole构建
 * @Date 2019/6/14 19:13
 *****/
@ApiModel(description = "SysUserRole",value = "SysUserRole")
@Table(name="sys_user_role")
public class SysUserRole implements Serializable{

	@ApiModelProperty(value = "用户id",required = false)
	@Id
    @Column(name = "id")
	private String id;//用户id

	@ApiModelProperty(value = "",required = false)
    @Column(name = "user_id")
	private String userId;//

	@ApiModelProperty(value = "角色id",required = false)
    @Column(name = "role_id")
	private String roleId;//角色id

	@ApiModelProperty(value = "创建时间",required = false)
    @Column(name = "create_time")
	private Date createTime;//创建时间



	//get方法
	public String getId() {
		return id;
	}

	//set方法
	public void setId(String id) {
		this.id = id;
	}
	//get方法
	public String getUserId() {
		return userId;
	}

	//set方法
	public void setUserId(String userId) {
		this.userId = userId;
	}
	//get方法
	public String getRoleId() {
		return roleId;
	}

	//set方法
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	//get方法
	public Date getCreateTime() {
		return createTime;
	}

	//set方法
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}


}
