package com.jeekite.sys.entity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.*;
import java.io.Serializable;
import java.lang.String;
/****
 * @Author:dudianlong
 * @Description:SysRolePermission构建
 * @Date 2020/5/14 19:13
 *****/
@ApiModel(description = "SysRolePermission",value = "SysRolePermission")
@Table(name="sys_role_permission")
public class SysRolePermission implements Serializable{

	@ApiModelProperty(value = "",required = false)
	@Id
    @Column(name = "id")
	private String id;//

	@ApiModelProperty(value = "角色id",required = false)
    @Column(name = "role_id")
	private String roleId;//角色id

	@ApiModelProperty(value = "权限id",required = false)
    @Column(name = "permission_id")
	private String permissionId;//权限id

	@ApiModelProperty(value = "",required = false)
    @Column(name = "data_rule_ids")
	private String dataRuleIds;//



	//get方法
	public String getId() {
		return id;
	}

	//set方法
	public void setId(String id) {
		this.id = id;
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
	public String getPermissionId() {
		return permissionId;
	}

	//set方法
	public void setPermissionId(String permissionId) {
		this.permissionId = permissionId;
	}
	//get方法
	public String getDataRuleIds() {
		return dataRuleIds;
	}

	//set方法
	public void setDataRuleIds(String dataRuleIds) {
		this.dataRuleIds = dataRuleIds;
	}


}
