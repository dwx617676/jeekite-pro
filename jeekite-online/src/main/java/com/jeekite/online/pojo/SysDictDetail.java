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
 * @Description:SysDictDetail构建
 * @Date 2019/6/14 19:13
 *****/
@ApiModel(description = "SysDictDetail",value = "SysDictDetail")
@Table(name="sys_dict_detail")
public class SysDictDetail implements Serializable{

	@ApiModelProperty(value = "",required = false)
	@Id
    @Column(name = "id")
	private String id;//

	@ApiModelProperty(value = "字典标签",required = false)
    @Column(name = "label")
	private String label;//字典标签

	@ApiModelProperty(value = "字典值",required = false)
    @Column(name = "value")
	private String value;//字典值

	@ApiModelProperty(value = "排序",required = false)
    @Column(name = "sort")
	private Integer sort;//排序

	@ApiModelProperty(value = "字典id",required = false)
    @Column(name = "dict_id")
	private String dictId;//字典id

	@ApiModelProperty(value = "创建日期",required = false)
    @Column(name = "create_time")
	private Date createTime;//创建日期



	//get方法
	public String getId() {
		return id;
	}

	//set方法
	public void setId(String id) {
		this.id = id;
	}
	//get方法
	public String getLabel() {
		return label;
	}

	//set方法
	public void setLabel(String label) {
		this.label = label;
	}
	//get方法
	public String getValue() {
		return value;
	}

	//set方法
	public void setValue(String value) {
		this.value = value;
	}
	//get方法
	public Integer getSort() {
		return sort;
	}

	//set方法
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	//get方法
	public String getDictId() {
		return dictId;
	}

	//set方法
	public void setDictId(String dictId) {
		this.dictId = dictId;
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
