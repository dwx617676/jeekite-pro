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
 * @Description:SysRole构建
 * @Date 2019/6/14 19:13
 *****/
@ApiModel(description = "SysRole",value = "SysRole")
@Table(name="sys_role")
public class SysRole implements Serializable{

	@ApiModelProperty(value = "主键",required = false)
	@Id
    @Column(name = "id")
	private String id;//主键

	@ApiModelProperty(value = "角色名称",required = false)
    @Column(name = "name")
	private String name;//角色名称

	@ApiModelProperty(value = "",required = false)
    @Column(name = "description")
	private String description;//

	@ApiModelProperty(value = "状态(1:正常0:弃用)",required = false)
    @Column(name = "status")
	private Integer status;//状态(1:正常0:弃用)

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
	public String getName() {
		return name;
	}

	//set方法
	public void setName(String name) {
		this.name = name;
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
	public Integer getStatus() {
		return status;
	}

	//set方法
	public void setStatus(Integer status) {
		this.status = status;
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
