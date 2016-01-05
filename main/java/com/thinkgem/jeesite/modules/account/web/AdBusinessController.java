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
import com.thinkgem.jeesite.modules.account.entity.AdBusiness;
import com.thinkgem.jeesite.modules.account.service.AdBusinessService;

/**
 * 账户管理Controller
 * @author wj
 * @version 2015-12-04
 */
@Controller
@RequestMapping(value = "${adminPath}/account/adBusiness")
public class AdBusinessController extends BaseController {

	@Autowired
	private AdBusinessService adBusinessService;
	
	@ModelAttribute
	public AdBusiness get(@RequestParam(required=false) String id) {
		AdBusiness entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = adBusinessService.get(id);
		}
		if (entity == null){
			entity = new AdBusiness();
		}
		return entity;
	}
	
	@RequiresPermissions("account:adBusiness:view")
	@RequestMapping(value = {"list", ""})
	public String list(AdBusiness adBusiness, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<AdBusiness> page = adBusinessService.findPage(new Page<AdBusiness>(request, response), adBusiness); 
		model.addAttribute("page", page);
		return "modules/account/adBusinessList";
	}

	@RequiresPermissions("account:adBusiness:view")
	@RequestMapping(value = "form")
	public String form(AdBusiness adBusiness, Model model) {
		model.addAttribute("adBusiness", adBusiness);
		return "modules/account/adBusinessForm";
	}

	@RequiresPermissions("account:adBusiness:edit")
	@RequestMapping(value = "save")
	public String save(AdBusiness adBusiness, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, adBusiness)){
			return form(adBusiness, model);
		}
		adBusinessService.save(adBusiness);
		addMessage(redirectAttributes, "保存账户管理成功");
		return "redirect:"+Global.getAdminPath()+"/account/adBusiness/?repage";
	}
	
	@RequiresPermissions("account:adBusiness:edit")
	@RequestMapping(value = "delete")
	public String delete(AdBusiness adBusiness, RedirectAttributes redirectAttributes) {
		adBusinessService.delete(adBusiness);
		addMessage(redirectAttributes, "删除账户管理成功");
		return "redirect:"+Global.getAdminPath()+"/account/adBusiness/?repage";
	}

}