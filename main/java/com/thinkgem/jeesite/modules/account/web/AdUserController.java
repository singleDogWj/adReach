/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.account.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.account.entity.AdUser;
import com.thinkgem.jeesite.modules.account.service.AdUserService;

/**
 * 员工账户管理Controller
 * @author shinex
 * @version 2015-12-09
 */
@Controller
@RequestMapping(value = "${adminPath}/account/adUser")
public class AdUserController extends BaseController {

	@Autowired
	private AdUserService adUserService;
	
	@ModelAttribute
	public AdUser get(@RequestParam(required=false) String id) {
		AdUser entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = adUserService.get(id);
		}
		if (entity == null){
			entity = new AdUser();
		}
		return entity;
	}
	
	@RequiresPermissions("account:adUser:view")
	@RequestMapping(value = {"list", ""})
	public String list(AdUser adUser, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<AdUser> page = adUserService.findPage(new Page<AdUser>(request, response), adUser); 
		model.addAttribute("page", page);
		return "modules/account/adUserList";
	}

	@RequiresPermissions("account:adUser:view")
	@RequestMapping(value = "form")
	public String form(AdUser adUser, Model model) {
		model.addAttribute("adUser", adUser);
		return "modules/account/adUserForm";
	}

	@RequiresPermissions("account:adUser:edit")
	@RequestMapping(value = "save")
	public String save(AdUser adUser, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, adUser)){
			return form(adUser, model);
		}
		adUserService.save(adUser);
		addMessage(redirectAttributes, "保存员工账户成功");
		return "redirect:"+Global.getAdminPath()+"/account/adUser/?repage";
	}
	
	@RequiresPermissions("account:adUser:edit")
	@RequestMapping(value = "delete")
	public String delete(AdUser adUser, RedirectAttributes redirectAttributes) {
		adUserService.delete(adUser);
		addMessage(redirectAttributes, "删除员工账户成功");
		return "redirect:"+Global.getAdminPath()+"/account/adUser/?repage";
	}

}