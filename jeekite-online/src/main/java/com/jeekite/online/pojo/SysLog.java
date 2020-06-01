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
 * @Description:SysLog构建
 * @Date 2019/6/14 19:13
 *****/
@ApiModel(description = "SysLog",value = "SysLog")
@Table(name="sys_log")
public class SysLog implements Serializable{

	@ApiModelProperty(value = "",required = false)
	@Id
    @Column(name = "id")
	private String id;//

	@ApiModelProperty(value = "用户id",required = false)
    @Column(name = "user_id")
	private String userId;//用户id

	@ApiModelProperty(value = "用户名",required = false)
    @Column(name = "username")
	private String username;//用户名

	@ApiModelProperty(value = "用户操作",required = false)
    @Column(name = "operation")
	private String operation;//用户操作

	@ApiModelProperty(value = "响应时间",required = false)
    @Column(name = "time")
	private Integer time;//响应时间

	@ApiModelProperty(value = "请求方法",required = false)
    @Column(name = "method")
	private String method;//请求方法

	@ApiModelProperty(value = "请求参数",required = false)
    @Column(name = "params")
	private String params;//请求参数

	@ApiModelProperty(value = "IP地址",required = false)
    @Column(name = "ip")
	private String ip;//IP地址

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
	public String getUsername() {
		return username;
	}

	//set方法
	public void setUsername(String username) {
		this.username = username;
	}
	//get方法
	public String getOperation() {
		return operation;
	}

	//set方法
	public void setOperation(String operation) {
		this.operation = operation;
	}
	//get方法
	public Integer getTime() {
		return time;
	}

	//set方法
	public void setTime(Integer time) {
		this.time = time;
	}
	//get方法
	public String getMethod() {
		return method;
	}

	//set方法
	public void setMethod(String method) {
		this.method = method;
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
	public String getIp() {
		return ip;
	}

	//set方法
	public void setIp(String ip) {
		this.ip = ip;
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
