package com.jeekite.sys.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Data
public class SysDepart implements Serializable {
    private static final long serialVersionUID = 1L;
    
	/**ID*/

	private String id;
	/**父机构ID*/
	private String parentId;
	/**机构/部门名称*/

	private String departName;
	/**英文名*/

	private String departNameEn;
	/**缩写*/
	private String departNameAbbr;
	/**排序*/

	private Integer departOrder;
	/**描述*/

	private String description;
	/**机构类别 1组织机构，2岗位*/

	private String orgCategory;
	/**机构类型*/
	private String orgType;
	/**机构编码*/

	private String orgCode;
	/**手机号*/

	private String mobile;
	/**传真*/

	private String fax;
	/**地址*/

	private String address;
	/**备注*/

	private String memo;
	/**状态（1启用，0不启用）*/

	private String status;
	/**删除状态（0，正常，1已删除）*/

	private String delFlag;
	/**创建人*/
	private String createBy;
	/**创建日期*/
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date createTime;
	/**更新人*/
	private String updateBy;
	/**更新日期*/
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date updateTime;
	
	/**
	 * 重写equals方法
	 */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
			return true;
		}
        if (o == null || getClass() != o.getClass()) {
			return false;
		}
        if (!super.equals(o)) {
			return false;
		}
        SysDepart depart = (SysDepart) o;
        return Objects.equals(id, depart.id) &&
                Objects.equals(parentId, depart.parentId) &&
                Objects.equals(departName, depart.departName) &&
                Objects.equals(departNameEn, depart.departNameEn) &&
                Objects.equals(departNameAbbr, depart.departNameAbbr) &&
                Objects.equals(departOrder, depart.departOrder) &&
                Objects.equals(description, depart.description) &&
                Objects.equals(orgCategory, depart.orgCategory) &&
                Objects.equals(orgType, depart.orgType) &&
                Objects.equals(orgCode, depart.orgCode) &&
                Objects.equals(mobile, depart.mobile) &&
                Objects.equals(fax, depart.fax) &&
                Objects.equals(address, depart.address) &&
                Objects.equals(memo, depart.memo) &&
                Objects.equals(status, depart.status) &&
                Objects.equals(delFlag, depart.delFlag) &&
                Objects.equals(createBy, depart.createBy) &&
                Objects.equals(createTime, depart.createTime) &&
                Objects.equals(updateBy, depart.updateBy) &&
                Objects.equals(updateTime, depart.updateTime);
    }

    /**
     * 重写hashCode方法
     */
    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), id, parentId, departName, 
        		departNameEn, departNameAbbr, departOrder, description,orgCategory, 
        		orgType, orgCode, mobile, fax, address, memo, status, 
        		delFlag, createBy, createTime, updateBy, updateTime);
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getDepartName() {
		return departName;
	}

	public void setDepartName(String departName) {
		this.departName = departName;
	}

	public String getDepartNameEn() {
		return departNameEn;
	}

	public void setDepartNameEn(String departNameEn) {
		this.departNameEn = departNameEn;
	}

	public String getDepartNameAbbr() {
		return departNameAbbr;
	}

	public void setDepartNameAbbr(String departNameAbbr) {
		this.departNameAbbr = departNameAbbr;
	}

	public Integer getDepartOrder() {
		return departOrder;
	}

	public void setDepartOrder(Integer departOrder) {
		this.departOrder = departOrder;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getOrgCategory() {
		return orgCategory;
	}

	public void setOrgCategory(String orgCategory) {
		this.orgCategory = orgCategory;
	}

	public String getOrgType() {
		return orgType;
	}

	public void setOrgType(String orgType) {
		this.orgType = orgType;
	}

	public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
}
