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
 * @Description:SysPermission构建
 * @Date 2019/6/14 19:13
 *****/
@ApiModel(description = "SysPermission",value = "SysPermission")
@Table(name="sys_permission")
public class SysPermission implements Serializable{

	@ApiModelProperty(value = "主键",required = false)
	@Id
    @Column(name = "id")
	private String id;//主键

	@ApiModelProperty(value = "菜单权限名称",required = false)
    @Column(name = "name")
	private String name;//菜单权限名称

	@ApiModelProperty(value = "授权(多个用逗号分隔，如：sys:user:add,sys:user:edit)",required = false)
    @Column(name = "perms")
	private String perms;//授权(多个用逗号分隔，如：sys:user:add,sys:user:edit)

	@ApiModelProperty(value = "图标",required = false)
    @Column(name = "icon")
	private String icon;//图标

	@ApiModelProperty(value = "访问地址URL",required = false)
    @Column(name = "url")
	private String url;//访问地址URL

	@ApiModelProperty(value = "a target属性:_self _blank",required = false)
    @Column(name = "target")
	private String target;//a target属性:_self _blank

	@ApiModelProperty(value = "父级菜单权限名称",required = false)
    @Column(name = "pid")
	private String pid;//父级菜单权限名称

	@ApiModelProperty(value = "排序",required = false)
    @Column(name = "order_num")
	private Integer orderNum;//排序

	@ApiModelProperty(value = "菜单权限类型(1:目录;2:菜单;3:按钮)",required = false)
    @Column(name = "type")
	private Integer type;//菜单权限类型(1:目录;2:菜单;3:按钮)

	@ApiModelProperty(value = "状态1:正常 0：禁用",required = false)
    @Column(name = "status")
	private Integer status;//状态1:正常 0：禁用

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
	public String getPerms() {
		return perms;
	}

	//set方法
	public void setPerms(String perms) {
		this.perms = perms;
	}
	//get方法
	public String getIcon() {
		return icon;
	}

	//set方法
	public void setIcon(String icon) {
		this.icon = icon;
	}
	//get方法
	public String getUrl() {
		return url;
	}

	//set方法
	public void setUrl(String url) {
		this.url = url;
	}
	//get方法
	public String getTarget() {
		return target;
	}

	//set方法
	public void setTarget(String target) {
		this.target = target;
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
	public Integer getOrderNum() {
		return orderNum;
	}

	//set方法
	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}
	//get方法
	public Integer getType() {
		return type;
	}

	//set方法
	public void setType(Integer type) {
		this.type = type;
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
