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
 * @Description:SysJobLog构建
 * @Date 2019/6/14 19:13
 *****/
@ApiModel(description = "SysJobLog",value = "SysJobLog")
@Table(name="sys_job_log")
public class SysJobLog implements Serializable{

	@ApiModelProperty(value = "任务日志id",required = false)
	@Id
    @Column(name = "id")
	private String id;//任务日志id

	@ApiModelProperty(value = "任务id",required = false)
    @Column(name = "job_id")
	private String jobId;//任务id

	@ApiModelProperty(value = "spring bean名称",required = false)
    @Column(name = "bean_name")
	private String beanName;//spring bean名称

	@ApiModelProperty(value = "参数",required = false)
    @Column(name = "params")
	private String params;//参数

	@ApiModelProperty(value = "任务状态    0：成功    1：失败",required = false)
    @Column(name = "status")
	private Integer status;//任务状态    0：成功    1：失败

	@ApiModelProperty(value = "失败信息",required = false)
    @Column(name = "error")
	private String error;//失败信息

	@ApiModelProperty(value = "耗时(单位：毫秒)",required = false)
    @Column(name = "times")
	private Integer times;//耗时(单位：毫秒)

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
	public String getJobId() {
		return jobId;
	}

	//set方法
	public void setJobId(String jobId) {
		this.jobId = jobId;
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
	public Integer getStatus() {
		return status;
	}

	//set方法
	public void setStatus(Integer status) {
		this.status = status;
	}
	//get方法
	public String getError() {
		return error;
	}

	//set方法
	public void setError(String error) {
		this.error = error;
	}
	//get方法
	public Integer getTimes() {
		return times;
	}

	//set方法
	public void setTimes(Integer times) {
		this.times = times;
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
