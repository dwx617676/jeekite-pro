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
 * @Description:SysJob构建
 * @Date 2019/6/14 19:13
 *****/
@ApiModel(description = "SysJob",value = "SysJob")
@Table(name="sys_job")
public class SysJob implements Serializable{

	@ApiModelProperty(value = "任务id",required = false)
	@Id
    @Column(name = "id")
	private String id;//任务id

	@ApiModelProperty(value = "spring bean名称",required = false)
    @Column(name = "bean_name")
	private String beanName;//spring bean名称

	@ApiModelProperty(value = "参数",required = false)
    @Column(name = "params")
	private String params;//参数

	@ApiModelProperty(value = "cron表达式",required = false)
    @Column(name = "cron_expression")
	private String cronExpression;//cron表达式

	@ApiModelProperty(value = "任务状态  0：正常  1：暂停",required = false)
    @Column(name = "status")
	private Integer status;//任务状态  0：正常  1：暂停

	@ApiModelProperty(value = "备注",required = false)
    @Column(name = "remark")
	private String remark;//备注

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
	public String getBeanName() {
		return beanName;
	}

	//set方法
	public void setBeanName(String beanName) {
		this.beanName = beanName;
	}
	//get方法
	public String getParams() {
		return params;
	}

	//set方法
	public void setParams(String params) {
		this.params = params;
	}
	//get方法
	public String getCronExpression() {
		return cronExpression;
	}

	//set方法
	public void setCronExpression(String cronExpression) {
		this.cronExpression = cronExpression;
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
	public String getRemark() {
		return remark;
	}

	//set方法
	public void setRemark(String remark) {
		this.remark = remark;
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
