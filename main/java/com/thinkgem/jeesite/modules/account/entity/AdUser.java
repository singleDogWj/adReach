/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.account.entity;

import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotNull;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 员工账户管理Entity
 * @author shinex
 * @version 2015-12-09
 */
public class AdUser extends DataEntity<AdUser> {
	
	private static final long serialVersionUID = 1L;
	private String groupNum;		// 企业编号
	private String cardNumber;		// 会员卡号
	private String sex;		// 性别
	private String name;		// 真实姓名
	private String telephone;		// 注册电话
	private String mailbox;		// 邮箱
	private String identityCard;		// 身份证
	private String password;		// 登录密码
	private String payPassword;		// 支付密码
	private Double integral;		// 可用积分账户
	private Double startIntegral;		// 初始积分
	private Double expectIntegral;		// 预积分账户
	private Double lineCredit;		// 支付额度
	private String isActive;		// 会员状态
	private String isPayPassword;		// 支付密码开关
	private Integer type;		// 会员类型
	
	public AdUser() {
		super();
	}

	public AdUser(String id){
		super(id);
	}

	@Length(min=1, max=64, message="企业编号长度必须介于 1 和 64 之间")
	public String getGroupNum() {
		return groupNum;
	}

	public void setGroupNum(String groupNum) {
		this.groupNum = groupNum;
	}
	
	@Length(min=1, max=100, message="会员卡号长度必须介于 1 和 100 之间")
	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	
	@Length(min=1, max=1, message="性别长度必须介于 1 和 1 之间")
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	
	@Length(min=1, max=20, message="真实姓名长度必须介于 1 和 20 之间")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Length(min=1, max=20, message="注册电话长度必须介于 1 和 20 之间")
	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	@Length(min=0, max=100, message="邮箱长度必须介于 0 和 100 之间")
	public String getMailbox() {
		return mailbox;
	}

	public void setMailbox(String mailbox) {
		this.mailbox = mailbox;
	}
	
	@Length(min=1, max=30, message="身份证长度必须介于 1 和 30 之间")
	public String getIdentityCard() {
		return identityCard;
	}

	public void setIdentityCard(String identityCard) {
		this.identityCard = identityCard;
	}
	
	@Length(min=1, max=255, message="登录密码长度必须介于 1 和 255 之间")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@Length(min=1, max=255, message="支付密码长度必须介于 1 和 255 之间")
	public String getPayPassword() {
		return payPassword;
	}

	public void setPayPassword(String payPassword) {
		this.payPassword = payPassword;
	}
	
	public Double getIntegral() {
		return integral;
	}

	public void setIntegral(Double integral) {
		this.integral = integral;
	}
	
	public Double getStartIntegral() {
		return startIntegral;
	}

	public void setStartIntegral(Double startIntegral) {
		this.startIntegral = startIntegral;
	}
	
	public Double getExpectIntegral() {
		return expectIntegral;
	}

	public void setExpectIntegral(Double expectIntegral) {
		this.expectIntegral = expectIntegral;
	}
	
	public Double getLineCredit() {
		return lineCredit;
	}

	public void setLineCredit(Double lineCredit) {
		this.lineCredit = lineCredit;
	}
	
	@Length(min=1, max=1, message="会员状态长度必须介于 1 和 1 之间")
	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	
	@Length(min=0, max=1, message="支付密码开关长度必须介于 0 和 1 之间")
	public String getIsPayPassword() {
		return isPayPassword;
	}

	public void setIsPayPassword(String isPayPassword) {
		this.isPayPassword = isPayPassword;
	}
	
	@NotNull(message="会员类型不能为空")
	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}
	
}