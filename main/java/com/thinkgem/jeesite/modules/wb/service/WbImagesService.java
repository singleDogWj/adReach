/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.wb.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.wb.entity.WbImages;
import com.thinkgem.jeesite.modules.wb.dao.WbImagesDao;

/**
 * 鸟图片库Service
 * @author willie
 * @version 2015-12-03
 */
@Service
@Transactional(readOnly = true)
public class WbImagesService extends CrudService<WbImagesDao, WbImages> {

	public WbImages get(String id) {
		return super.get(id);
	}
	
	public List<WbImages> findList(WbImages wbImages) {
		return super.findList(wbImages);
	}
	
	public Page<WbImages> findPage(Page<WbImages> page, WbImages wbImages) {
		return super.findPage(page, wbImages);
	}
	
	@Transactional(readOnly = false)
	public void save(WbImages wbImages) {
		super.save(wbImages);
	}
	
	@Transactional(readOnly = false)
	public void delete(WbImages wbImages) {
		super.delete(wbImages);
	}
	
}