package com.jeekite.sys.entity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.lang.String;
/****
 * @Author:dudianlong
 * @Description:SysUser构建
 * @Date 2020/5/14 19:13
 *****/
@ApiModel(description = "SysUser",value = "SysUser")
@Table(name="sys_user")
public class SysUser implements Serializable{

	@ApiModelProperty(value = "主键id",required = false)
	@Id
    @Column(name = "id")
	private String id;//主键id

	@ApiModelProperty(value = "登录账号",required = false)
    @Column(name = "username")
	private String username;//登录账号

	@ApiModelProperty(value = "真实姓名",required = false)
    @Column(name = "realname")
	private String realname;//真实姓名

	@ApiModelProperty(value = "密码",required = false)
    @Column(name = "password")
	private String password;//密码

	@ApiModelProperty(value = "md5密码盐",required = false)
    @Column(name = "salt")
	private String salt;//md5密码盐

	@ApiModelProperty(value = "头像",required = false)
    @Column(name = "avatar")
	private String avatar;//头像

	@ApiModelProperty(value = "生日",required = false)
    @Column(name = "birthday")
	private Date birthday;//生日

	@ApiModelProperty(value = "性别(0-默认未知,1-男,2-女)",required = false)
    @Column(name = "sex")
	private String sex;//性别(0-默认未知,1-男,2-女)

	@ApiModelProperty(value = "电子邮件",required = false)
    @Column(name = "email")
	private String email;//电子邮件

	@ApiModelProperty(value = "电话",required = false)
    @Column(name = "phone")
	private String phone;//电话

	@ApiModelProperty(value = "机构编码",required = false)
    @Column(name = "org_code")
	private String orgCode;//机构编码

	@ApiModelProperty(value = "性别(1-正常,2-冻结)",required = false)
    @Column(name = "status")
	private String status;//性别(1-正常,2-冻结)

	@ApiModelProperty(value = "删除状态(0-正常,1-已删除)",required = false)
    @Column(name = "del_flag")
	private String delFlag;//删除状态(0-正常,1-已删除)

	@ApiModelProperty(value = "第三方登录的唯一标识",required = false)
    @Column(name = "third_id")
	private String thirdId;//第三方登录的唯一标识

	@ApiModelProperty(value = "第三方类型",required = false)
    @Column(name = "third_type")
	private String thirdType;//第三方类型

	@ApiModelProperty(value = "同步工作流引擎(1-同步,0-不同步)",required = false)
    @Column(name = "activiti_sync")
	private String activitiSync;//同步工作流引擎(1-同步,0-不同步)

	@ApiModelProperty(value = "工号，唯一键",required = false)
    @Column(name = "work_no")
	private String workNo;//工号，唯一键

	@ApiModelProperty(value = "职务，关联职务表",required = false)
    @Column(name = "post")
	private String post;//职务，关联职务表

	@ApiModelProperty(value = "座机号",required = false)
    @Column(name = "telephone")
	private String telephone;//座机号

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

	@ApiModelProperty(value = "身份（1普通成员 2上级）",required = false)
    @Column(name = "user_identity")
	private String userIdentity;//身份（1普通成员 2上级）

	@ApiModelProperty(value = "负责部门",required = false)
    @Column(name = "depart_ids")
	private String departIds;//负责部门



	//get方法
	public String getId() {
		return id;
	}

	//set方法
	public void setId(String id) {
		this.id = id;
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
	public String getRealname() {
		return realname;
	}

	//set方法
	public void setRealname(String realname) {
		this.realname = realname;
	}
	//get方法
	public String getPassword() {
		return password;
	}

	//set方法
	public void setPassword(String password) {
		this.password = password;
	}
	//get方法
	public String getSalt() {
		return salt;
	}

	//set方法
	public void setSalt(String salt) {
		this.salt = salt;
	}
	//get方法
	public String getAvatar() {
		return avatar;
	}

	//set方法
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	//get方法
	public Date getBirthday() {
		return birthday;
	}

	//set方法
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	//get方法
	public String getSex() {
		return sex;
	}

	//set方法
	public void setSex(String sex) {
		this.sex = sex;
	}
	//get方法
	public String getEmail() {
		return email;
	}

	//set方法
	public void setEmail(String email) {
		this.email = email;
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
	public String getOrgCode() {
		return orgCode;
	}

	//set方法
	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
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
	public String getDelFlag() {
		return delFlag;
	}

	//set方法
	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}
	//get方法
	public String getThirdId() {
		return thirdId;
	}

	//set方法
	public void setThirdId(String thirdId) {
		this.thirdId = thirdId;
	}
	//get方法
	public String getThirdType() {
		return thirdType;
	}

	//set方法
	public void setThirdType(String thirdType) {
		this.thirdType = thirdType;
	}
	//get方法
	public String getActivitiSync() {
		return activitiSync;
	}

	//set方法
	public void setActivitiSync(String activitiSync) {
		this.activitiSync = activitiSync;
	}
	//get方法
	public String getWorkNo() {
		return workNo;
	}

	//set方法
	public void setWorkNo(String workNo) {
		this.workNo = workNo;
	}
	//get方法
	public String getPost() {
		return post;
	}

	//set方法
	public void setPost(String post) {
		this.post = post;
	}
	//get方法
	public String getTelephone() {
		return telephone;
	}

	//set方法
	public void setTelephone(String telephone) {
		this.telephone = telephone;
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
	public String getUserIdentity() {
		return userIdentity;
	}

	//set方法
	public void setUserIdentity(String userIdentity) {
		this.userIdentity = userIdentity;
	}
	//get方法
	public String getDepartIds() {
		return departIds;
	}

	//set方法
	public void setDepartIds(String departIds) {
		this.departIds = departIds;
	}


}
