/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.account.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.account.entity.AdBusiness;

/**
 * 账户管理DAO接口
 * @author wj
 * @version 2015-12-04
 */
@MyBatisDao
public interface AdBusinessDao extends CrudDao<AdBusiness> {
	
}