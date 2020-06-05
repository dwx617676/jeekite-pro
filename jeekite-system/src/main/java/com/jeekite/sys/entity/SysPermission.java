package com.jeekite.sys.entity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.*;
import java.io.Serializable;
import java.lang.Double;
import java.util.Date;
import java.lang.String;
import java.lang.Integer;
/****
 * @Author:dudianlong
 * @Description:SysPermission构建
 * @Date 2020/5/14 19:13
 *****/
@ApiModel(description = "SysPermission",value = "SysPermission")
@Table(name="sys_permission")
public class SysPermission implements Serializable{

	@ApiModelProperty(value = "主键id",required = false)
	@Id
    @Column(name = "id")
	private String id;//主键id

	@ApiModelProperty(value = "父id",required = false)
    @Column(name = "parent_id")
	private String parentId;//父id

	@ApiModelProperty(value = "菜单标题",required = false)
    @Column(name = "name")
	private String name;//菜单标题

	@ApiModelProperty(value = "路径",required = false)
    @Column(name = "url")
	private String url;//路径

	@ApiModelProperty(value = "组件",required = false)
    @Column(name = "component")
	private String component;//组件

	@ApiModelProperty(value = "组件名字",required = false)
    @Column(name = "component_name")
	private String componentName;//组件名字

	@ApiModelProperty(value = "一级菜单跳转地址",required = false)
    @Column(name = "redirect")
	private String redirect;//一级菜单跳转地址

	@ApiModelProperty(value = "菜单类型(0:一级菜单; 1:子菜单:2:按钮权限)",required = false)
    @Column(name = "menu_type")
	private Integer menuType;//菜单类型(0:一级菜单; 1:子菜单:2:按钮权限)

	@ApiModelProperty(value = "菜单权限编码",required = false)
    @Column(name = "perms")
	private String perms;//菜单权限编码

	@ApiModelProperty(value = "权限策略1显示2禁用",required = false)
    @Column(name = "perms_type")
	private String permsType;//权限策略1显示2禁用

	@ApiModelProperty(value = "菜单排序",required = false)
    @Column(name = "sort_no")
	private Double sortNo;//菜单排序

	@ApiModelProperty(value = "聚合子路由: 1是0否",required = false)
    @Column(name = "always_show")
	private String alwaysShow;//聚合子路由: 1是0否

	@ApiModelProperty(value = "菜单图标",required = false)
    @Column(name = "icon")
	private String icon;//菜单图标

	@ApiModelProperty(value = "是否路由菜单: 0:不是  1:是（默认值1）",required = false)
    @Column(name = "is_route")
	private String isRoute;//是否路由菜单: 0:不是  1:是（默认值1）

	@ApiModelProperty(value = "是否叶子节点:    1:是   0:不是",required = false)
    @Column(name = "is_leaf")
	private String isLeaf;//是否叶子节点:    1:是   0:不是

	@ApiModelProperty(value = "是否缓存该页面:    1:是   0:不是",required = false)
    @Column(name = "keep_alive")
	private String keepAlive;//是否缓存该页面:    1:是   0:不是

	@ApiModelProperty(value = "是否隐藏路由: 0否,1是",required = false)
    @Column(name = "hidden")
	private Integer hidden;//是否隐藏路由: 0否,1是

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

	@ApiModelProperty(value = "删除状态 0正常 1已删除",required = false)
    @Column(name = "del_flag")
	private Integer delFlag;//删除状态 0正常 1已删除

	@ApiModelProperty(value = "是否添加数据权限1是0否",required = false)
    @Column(name = "rule_flag")
	private Integer ruleFlag;//是否添加数据权限1是0否

	@ApiModelProperty(value = "按钮权限状态(0无效1有效)",required = false)
    @Column(name = "status")
	private String status;//按钮权限状态(0无效1有效)

	@ApiModelProperty(value = "外链菜单打开方式 0/内部打开 1/外部打开",required = false)
    @Column(name = "internal_or_external")
	private String internalOrExternal;//外链菜单打开方式 0/内部打开 1/外部打开



	//get方法
	public String getId() {
		return id;
	}

	//set方法
	public void setId(String id) {
		this.id = id;
	}
	//get方法
	public String getParentId() {
		return parentId;
	}

	//set方法
	public void setParentId(String parentId) {
		this.parentId = parentId;
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
	public String getUrl() {
		return url;
	}

	//set方法
	public void setUrl(String url) {
		this.url = url;
	}
	//get方法
	public String getComponent() {
		return component;
	}

	//set方法
	public void setComponent(String component) {
		this.component = component;
	}
	//get方法
	public String getComponentName() {
		return componentName;
	}

	//set方法
	public void setComponentName(String componentName) {
		this.componentName = componentName;
	}
	//get方法
	public String getRedirect() {
		return redirect;
	}

	//set方法
	public void setRedirect(String redirect) {
		this.redirect = redirect;
	}
	//get方法
	public Integer getMenuType() {
		return menuType;
	}

	//set方法
	public void setMenuType(Integer menuType) {
		this.menuType = menuType;
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
	public String getPermsType() {
		return permsType;
	}

	//set方法
	public void setPermsType(String permsType) {
		this.permsType = permsType;
	}
	//get方法
	public Double getSortNo() {
		return sortNo;
	}

	//set方法
	public void setSortNo(Double sortNo) {
		this.sortNo = sortNo;
	}
	//get方法
	public String getAlwaysShow() {
		return alwaysShow;
	}

	//set方法
	public void setAlwaysShow(String alwaysShow) {
		this.alwaysShow = alwaysShow;
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
	public String getIsRoute() {
		return isRoute;
	}

	//set方法
	public void setIsRoute(String isRoute) {
		this.isRoute = isRoute;
	}
	//get方法
	public String getIsLeaf() {
		return isLeaf;
	}

	//set方法
	public void setIsLeaf(String isLeaf) {
		this.isLeaf = isLeaf;
	}
	//get方法
	public String getKeepAlive() {
		return keepAlive;
	}

	//set方法
	public void setKeepAlive(String keepAlive) {
		this.keepAlive = keepAlive;
	}
	//get方法
	public Integer getHidden() {
		return hidden;
	}

	//set方法
	public void setHidden(Integer hidden) {
		this.hidden = hidden;
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
	//get方法
	public Integer getDelFlag() {
		return delFlag;
	}

	//set方法
	public void setDelFlag(Integer delFlag) {
		this.delFlag = delFlag;
	}
	//get方法
	public Integer getRuleFlag() {
		return ruleFlag;
	}

	//set方法
	public void setRuleFlag(Integer ruleFlag) {
		this.ruleFlag = ruleFlag;
	}
	//get方法
	public String getStatus() {
		return status;
	}

	//set方法
	public void setStatus(String status) {
		this.status = status;
	}
	//get方法
	public String getInternalOrExternal() {
		return internalOrExternal;
	}

	//set方法
	public void setInternalOrExternal(String internalOrExternal) {
		this.internalOrExternal = internalOrExternal;
	}


}
