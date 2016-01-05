/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.account.entity;

import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotNull;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 账户管理Entity
 * @author wj
 * @version 2015-12-04
 */
public class AdBusiness extends DataEntity<AdBusiness> {
	
	private static final long serialVersionUID = 1L;
	private String company;		// 商户名称
	private String type;		// 商户类型
	private String logo;		// 商户图标
	private String url;		// 链接地址
	private String businessId;		// 商户编号
	private String userName;		// 权限帐号
	private String password;		// 权限密码
	private Double userRebate;		// 返利比例
	private Double bussinessRebate;		// 返佣比例
	private String unionLogin;		// 联合登录回调地址
	private String dataSynchronization;		// 同步开关
	private String bussinessRebateType;		// 返佣类型
	private String userRebateType;		// 返利类型
	private String memo;		// 备注
	private String isActive;		// 账户状态
	
	public AdBusiness() {
		super();
	}

	public AdBusiness(String id){
		super(id);
	}

	@Length(min=1, max=100, message="商户名称长度必须介于 1 和 100 之间")
	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}
	
	@Length(min=0, max=2, message="商户类型长度必须介于 0 和 2 之间")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	@Length(min=0, max=100, message="商户图标长度必须介于 0 和 100 之间")
	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}
	
	@Length(min=0, max=100, message="链接地址长度必须介于 0 和 100 之间")
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	@Length(min=1, max=100, message="商户编号长度必须介于 1 和 100 之间")
	public String getBusinessId() {
		return businessId;
	}

	public void setBusinessId(String businessId) {
		this.businessId = businessId;
	}
	
	@Length(min=0, max=255, message="权限帐号长度必须介于 0 和 255 之间")
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	@Length(min=0, max=255, message="权限密码长度必须介于 0 和 255 之间")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@NotNull(message="返利比例不能为空")
	public Double getUserRebate() {
		return userRebate;
	}

	public void setUserRebate(Double userRebate) {
		this.userRebate = userRebate;
	}
	
	@NotNull(message="返佣比例不能为空")
	public Double getBussinessRebate() {
		return bussinessRebate;
	}

	public void setBussinessRebate(Double bussinessRebate) {
		this.bussinessRebate = bussinessRebate;
	}
	
	@Length(min=0, max=100, message="联合登录回调地址长度必须介于 0 和 100 之间")
	public String getUnionLogin() {
		return unionLogin;
	}

	public void setUnionLogin(String unionLogin) {
		this.unionLogin = unionLogin;
	}
	
	@Length(min=0, max=1, message="同步开关长度必须介于 0 和 1 之间")
	public String getDataSynchronization() {
		return dataSynchronization;
	}

	public void setDataSynchronization(String dataSynchronization) {
		this.dataSynchronization = dataSynchronization;
	}
	
	@Length(min=1, max=1, message="返佣类型长度必须介于 1 和 1 之间")
	public String getBussinessRebateType() {
		return bussinessRebateType;
	}

	public void setBussinessRebateType(String bussinessRebateType) {
		this.bussinessRebateType = bussinessRebateType;
	}
	
	@Length(min=1, max=1, message="返利类型长度必须介于 1 和 1 之间")
	public String getUserRebateType() {
		return userRebateType;
	}

	public void setUserRebateType(String userRebateType) {
		this.userRebateType = userRebateType;
	}
	
	@Length(min=0, max=100, message="备注长度必须介于 0 和 100 之间")
	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}
	
	@Length(min=0, max=1, message="账户状态长度必须介于 0 和 1 之间")
	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	
}