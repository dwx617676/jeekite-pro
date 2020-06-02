package com.jeekite.online.pojo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.lang.String;
import java.lang.Integer;
/****
 * @Author:dudianlong
 * @Description:SysUser构建
 * @Date 2020/5/14 19:13
 *****/
@ApiModel(description = "SysUser",value = "SysUser")
@Table(name="sys_user")
public class SysUser implements Serializable{

	@ApiModelProperty(value = "用户id",required = false)
	@Id
    @Column(name = "id")
	private String id;//用户id

	@ApiModelProperty(value = "账户名称",required = false)
    @Column(name = "username")
	private String username;//账户名称

	@ApiModelProperty(value = "加密盐值",required = false)
    @Column(name = "salt")
	private String salt;//加密盐值

	@ApiModelProperty(value = "用户密码密文",required = false)
    @Column(name = "password")
	private String password;//用户密码密文

	@ApiModelProperty(value = "手机号码",required = false)
    @Column(name = "phone")
	private String phone;//手机号码

	@ApiModelProperty(value = "部门id",required = false)
    @Column(name = "dept_id")
	private String deptId;//部门id

	@ApiModelProperty(value = "真实名称",required = false)
    @Column(name = "real_name")
	private String realName;//真实名称

	@ApiModelProperty(value = "昵称",required = false)
    @Column(name = "nick_name")
	private String nickName;//昵称

	@ApiModelProperty(value = "邮箱(唯一)",required = false)
    @Column(name = "email")
	private String email;//邮箱(唯一)

	@ApiModelProperty(value = "账户状态(1.正常 2.锁定 )",required = false)
    @Column(name = "status")
	private Integer status;//账户状态(1.正常 2.锁定 )

	@ApiModelProperty(value = "性别(1.男 2.女)",required = false)
    @Column(name = "sex")
	private Integer sex;//性别(1.男 2.女)

	@ApiModelProperty(value = "是否删除(1未删除；0已删除)",required = false)
    @Column(name = "deleted")
	private Integer deleted;//是否删除(1未删除；0已删除)

	@ApiModelProperty(value = "创建人",required = false)
    @Column(name = "create_id")
	private String createId;//创建人

	@ApiModelProperty(value = "更新人",required = false)
    @Column(name = "update_id")
	private String updateId;//更新人

	@ApiModelProperty(value = "创建来源(1.web 2.android 3.ios )",required = false)
    @Column(name = "create_where")
	private Integer createWhere;//创建来源(1.web 2.android 3.ios )

	@ApiModelProperty(value = "创建时间",required = false)
    @Column(name = "create_time")
	private Date createTime;//创建时间

	@ApiModelProperty(value = "",required = false)
    @Column(name = "update_time")
	private Date updateTime;//



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
	public String getSalt() {
		return salt;
	}

	//set方法
	public void setSalt(String salt) {
		this.salt = salt;
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
	public String getPhone() {
		return phone;
	}

	//set方法
	public void setPhone(String phone) {
		this.phone = phone;
	}
	//get方法
	public String getDeptId() {
		return deptId;
	}

	//set方法
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	//get方法
	public String getRealName() {
		return realName;
	}

	//set方法
	public void setRealName(String realName) {
		this.realName = realName;
	}
	//get方法
	public String getNickName() {
		return nickName;
	}

	//set方法
	public void setNickName(String nickName) {
		this.nickName = nickName;
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
	public Integer getStatus() {
		return status;
	}

	//set方法
	public void setStatus(Integer status) {
		this.status = status;
	}
	//get方法
	public Integer getSex() {
		return sex;
	}

	//set方法
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	//get方法
	public Integer getDeleted() {
		return deleted;
	}

	//set方法
	public void setDeleted(Integer deleted) {
		this.deleted = deleted;
	}
	//get方法
	public String getCreateId() {
		return createId;
	}

	//set方法
	public void setCreateId(String createId) {
		this.createId = createId;
	}
	//get方法
	public String getUpdateId() {
		return updateId;
	}

	//set方法
	public void setUpdateId(String updateId) {
		this.updateId = updateId;
	}
	//get方法
	public Integer getCreateWhere() {
		return createWhere;
	}

	//set方法
	public void setCreateWhere(Integer createWhere) {
		this.createWhere = createWhere;
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


}
