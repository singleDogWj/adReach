/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.account.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.account.entity.AdGroup;
import com.thinkgem.jeesite.modules.account.dao.AdGroupDao;

/**
 * 企业账户管理Service
 * @author shinex
 * @version 2015-12-04
 */
@Service
@Transactional(readOnly = true)
public class AdGroupService extends CrudService<AdGroupDao, AdGroup> {

	public AdGroup get(String id) {
		return super.get(id);
	}
	
	public List<AdGroup> findList(AdGroup adGroup) {
		return super.findList(adGroup);
	}
	
	public Page<AdGroup> findPage(Page<AdGroup> page, AdGroup adGroup) {
		return super.findPage(page, adGroup);
	}
	
	@Transactional(readOnly = false)
	public void save(AdGroup adGroup) {
		super.save(adGroup);
	}
	
	@Transactional(readOnly = false)
	public void delete(AdGroup adGroup) {
		super.delete(adGroup);
	}
	
}