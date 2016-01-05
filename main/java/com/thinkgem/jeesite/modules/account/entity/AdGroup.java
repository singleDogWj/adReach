/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.account.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 企业账户管理Entity
 * @author shinex
 * @version 2015-12-04
 */
public class AdGroup extends DataEntity<AdGroup> {
	
	private static final long serialVersionUID = 1L;
	private String groupName;		// 企业名称
	private String groupNum;		// 企业编号
	private String isActive;		// 账户状态
	private Double officialIntegral;		// 正式员工起始积分定制
	private String officialNumber;		// 正式员工号定制
	private String relationStartNo;		// 编号开始值
	private String relationEndNo;		// 编号结束值
	private Long superGroupId;		// 上一级企业编号
	private String udId;		// 识别码
	private Double unOfficialIntegral;		// 非正式员工起始积分定制
	
	public AdGroup() {
		super();
	}

	public AdGroup(String id){
		super(id);
	}

	@Length(min=0, max=64, message="企业名称长度必须介于 0 和 64 之间")
	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	
	@Length(min=1, max=64, message="企业编号长度必须介于 1 和 64 之间")
	public String getGroupNum() {
		return groupNum;
	}

	public void setGroupNum(String groupNum) {
		this.groupNum = groupNum;
	}
	
	@Length(min=1, max=1, message="账户状态长度必须介于 1 和 1 之间")
	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	
	public Double getOfficialIntegral() {
		return officialIntegral;
	}

	public void setOfficialIntegral(Double officialIntegral) {
		this.officialIntegral = officialIntegral;
	}
	
	@Length(min=0, max=255, message="正式员工号定制长度必须介于 0 和 255 之间")
	public String getOfficialNumber() {
		return officialNumber;
	}

	public void setOfficialNumber(String officialNumber) {
		this.officialNumber = officialNumber;
	}
	
	@Length(min=0, max=2, message="编号开始值长度必须介于 0 和 2 之间")
	public String getRelationStartNo() {
		return relationStartNo;
	}

	public void setRelationStartNo(String relationStartNo) {
		this.relationStartNo = relationStartNo;
	}
	
	@Length(min=0, max=2, message="编号结束值长度必须介于 0 和 2 之间")
	public String getRelationEndNo() {
		return relationEndNo;
	}

	public void setRelationEndNo(String relationEndNo) {
		this.relationEndNo = relationEndNo;
	}
	
	public Long getSuperGroupId() {
		return superGroupId;
	}

	public void setSuperGroupId(Long superGroupId) {
		this.superGroupId = superGroupId;
	}
	
	@Length(min=0, max=64, message="识别码长度必须介于 0 和 64 之间")
	public String getUdId() {
		return udId;
	}

	public void setUdId(String udId) {
		this.udId = udId;
	}
	
	public Double getUnOfficialIntegral() {
		return unOfficialIntegral;
	}

	public void setUnOfficialIntegral(Double unOfficialIntegral) {
		this.unOfficialIntegral = unOfficialIntegral;
	}
	
}