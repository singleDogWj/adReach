/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.account.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.account.entity.AdBusiness;
import com.thinkgem.jeesite.modules.account.dao.AdBusinessDao;

/**
 * 账户管理Service
 * @author wj
 * @version 2015-12-04
 */
@Service
@Transactional(readOnly = true)
public class AdBusinessService extends CrudService<AdBusinessDao, AdBusiness> {

	public AdBusiness get(String id) {
		return super.get(id);
	}
	
	public List<AdBusiness> findList(AdBusiness adBusiness) {
		return super.findList(adBusiness);
	}
	
	public Page<AdBusiness> findPage(Page<AdBusiness> page, AdBusiness adBusiness) {
		return super.findPage(page, adBusiness);
	}
	
	@Transactional(readOnly = false)
	public void save(AdBusiness adBusiness) {
		super.save(adBusiness);
	}
	
	@Transactional(readOnly = false)
	public void delete(AdBusiness adBusiness) {
		super.delete(adBusiness);
	}
	
}