package com.jeekite.online.pojo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.lang.String;
import java.lang.Integer;
/****
 * @Author:shenkunlin
 * @Description:SysDept构建
 * @Date 2019/6/14 19:13
 *****/
@ApiModel(description = "SysDept",value = "SysDept")
@Table(name="sys_dept")
public class SysDept implements Serializable{

	@ApiModelProperty(value = "主键",required = false)
	@Id
    @Column(name = "id")
	private String id;//主键

	@ApiModelProperty(value = "部门编号(规则：父级关系编码+自己的编码)",required = false)
    @Column(name = "dept_no")
	private String deptNo;//部门编号(规则：父级关系编码+自己的编码)

	@ApiModelProperty(value = "部门名称",required = false)
    @Column(name = "name")
	private String name;//部门名称

	@ApiModelProperty(value = "父级id",required = false)
    @Column(name = "pid")
	private String pid;//父级id

	@ApiModelProperty(value = "状态(1:正常；0:弃用)",required = false)
    @Column(name = "status")
	private Integer status;//状态(1:正常；0:弃用)

	@ApiModelProperty(value = "为了维护更深层级关系",required = false)
    @Column(name = "relation_code")
	private String relationCode;//为了维护更深层级关系

	@ApiModelProperty(value = "部门经理user_id",required = false)
    @Column(name = "dept_manager_id")
	private String deptManagerId;//部门经理user_id

	@ApiModelProperty(value = "部门经理名称",required = false)
    @Column(name = "manager_name")
	private String managerName;//部门经理名称

	@ApiModelProperty(value = "部门经理联系电话",required = false)
    @Column(name = "phone")
	private String phone;//部门经理联系电话

	@ApiModelProperty(value = "创建时间",required = false)
    @Column(name = "create_time")
	private Date createTime;//创建时间

	@ApiModelProperty(value = "更新时间",required = false)
    @Column(name = "update_time")
	private Date updateTime;//更新时间

	@ApiModelProperty(value = "是否删除(1未删除；0已删除)",required = false)
    @Column(name = "deleted")
	private Integer deleted;//是否删除(1未删除；0已删除)



	//get方法
	public String getId() {
		return id;
	}

	//set方法
	public void setId(String id) {
		this.id = id;
	}
	//get方法
	public String getDeptNo() {
		return deptNo;
	}

	//set方法
	public void setDeptNo(String deptNo) {
		this.deptNo = deptNo;
	}
	//get方法
	public String getName() {
		return name;
	}

	//set方法
	public void setName(String name) {
		this.name = name;
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
	public Integer getStatus() {
		return status;
	}

	//set方法
	public void setStatus(Integer status) {
		this.status = status;
	}
	//get方法
	public String getRelationCode() {
		return relationCode;
	}

	//set方法
	public void setRelationCode(String relationCode) {
		this.relationCode = relationCode;
	}
	//get方法
	public String getDeptManagerId() {
		return deptManagerId;
	}

	//set方法
	public void setDeptManagerId(String deptManagerId) {
		this.deptManagerId = deptManagerId;
	}
	//get方法
	public String getManagerName() {
		return managerName;
	}

	//set方法
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	//get方法
	public String getPhone() {
		return phone;
	}

	//set方法
	public void setPhone(String phone) {
		this.phone = phone;
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
	public Date getUpdateTime() {
		return updateTime;
	}

	//set方法
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	//get方法
	public Integer getDeleted() {
		return deleted;
	}

	//set方法
	public void setDeleted(Integer deleted) {
		this.deleted = deleted;
	}


}
