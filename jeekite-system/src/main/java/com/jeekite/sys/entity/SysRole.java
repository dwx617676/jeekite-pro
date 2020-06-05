package com.jeekite.sys.entity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.lang.String;
/****
 * @Author:dudianlong
 * @Description:SysRole构建
 * @Date 2020/5/14 19:13
 *****/
@ApiModel(description = "SysRole",value = "SysRole")
@Table(name="sys_role")
public class SysRole implements Serializable{

	@ApiModelProperty(value = "主键id",required = false)
	@Id
    @Column(name = "id")
	private String id;//主键id

	@ApiModelProperty(value = "角色名称",required = false)
    @Column(name = "role_name")
	private String roleName;//角色名称

	@ApiModelProperty(value = "角色编码",required = false)
    @Column(name = "role_code")
	private String roleCode;//角色编码

	@ApiModelProperty(value = "描述",required = false)
    @Column(name = "description")
	private String description;//描述

	@ApiModelProperty(value = "创建人",required = false)
    @Column(name = "create_by")
	private String createBy;//创建人

	@ApiModelProperty(value = "创建时间",required = false)
    @Column(name = "create_time")
	private Date createTime;//创建时间

	@ApiModelProperty(value = "更新人",required = false)
    @Column(name = "update_by")
	private String updateBy;//更新人

	@ApiModelProperty(value = "更新时间",required = false)
    @Column(name = "update_time")
	private Date updateTime;//更新时间



	//get方法
	public String getId() {
		return id;
	}

	//set方法
	public void setId(String id) {
		this.id = id;
	}
	//get方法
	public String getRoleName() {
		return roleName;
	}

	//set方法
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	//get方法
	public String getRoleCode() {
		return roleCode;
	}

	//set方法
	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}
	//get方法
	public String getDescription() {
		return description;
	}

	//set方法
	public void setDescription(String description) {
		this.description = description;
	}
	//get方法
	public String getCreateBy() {
		return createBy;
	}

	//set方法
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	//get方法
	public Date getCreateTime() {
		return createTime;
	}

	//set方法
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	//get方法
	public String getUpdateBy() {
		return updateBy;
	}

	//set方法
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}
	//get方法
	public Date getUpdateTime() {
		return updateTime;
	}

	//set方法
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}


}
