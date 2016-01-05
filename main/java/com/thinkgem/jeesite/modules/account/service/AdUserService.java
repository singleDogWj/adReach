/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.account.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.account.entity.AdUser;
import com.thinkgem.jeesite.modules.account.dao.AdUserDao;

/**
 * 员工账户管理Service
 * @author shinex
 * @version 2015-12-09
 */
@Service
@Transactional(readOnly = true)
public class AdUserService extends CrudService<AdUserDao, AdUser> {

	public AdUser get(String id) {
		return super.get(id);
	}
	
	public List<AdUser> findList(AdUser adUser) {
		return super.findList(adUser);
	}
	
	public Page<AdUser> findPage(Page<AdUser> page, AdUser adUser) {
		return super.findPage(page, adUser);
	}
	
	@Transactional(readOnly = false)
	public void save(AdUser adUser) {
		super.save(adUser);
	}
	
	@Transactional(readOnly = false)
	public void delete(AdUser adUser) {
		super.delete(adUser);
	}
	
}