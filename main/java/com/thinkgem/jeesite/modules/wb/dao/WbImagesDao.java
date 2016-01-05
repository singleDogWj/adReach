/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.wb.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.wb.entity.WbImages;

/**
 * 鸟图片库DAO接口
 * @author willie
 * @version 2015-12-03
 */
@MyBatisDao
public interface WbImagesDao extends CrudDao<WbImages> {
	
}