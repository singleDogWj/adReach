/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.account.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.account.entity.AdUser;

/**
 * 员工账户管理DAO接口
 * @author shinex
 * @version 2015-12-09
 */
@MyBatisDao
public interface AdUserDao extends CrudDao<AdUser> {
	
}