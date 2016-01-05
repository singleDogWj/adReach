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
import com.thinkgem.jeesite.modules.account.entity.AdGroup;
import com.thinkgem.jeesite.modules.account.service.AdGroupService;

/**
 * 企业账户管理Controller
 * @author shinex
 * @version 2015-12-04
 */
@Controller
@RequestMapping(value = "${adminPath}/account/adGroup")
public class AdGroupController extends BaseController {

	@Autowired
	private AdGroupService adGroupService;
	
	@ModelAttribute
	public AdGroup get(@RequestParam(required=false) String id) {
		AdGroup entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = adGroupService.get(id);
		}
		if (entity == null){
			entity = new AdGroup();
		}
		return entity;
	}
	
	@RequiresPermissions("account:adGroup:view")
	@RequestMapping(value = {"list", ""})
	public String list(AdGroup adGroup, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<AdGroup> page = adGroupService.findPage(new Page<AdGroup>(request, response), adGroup); 
		model.addAttribute("page", page);
		return "modules/account/adGroupList";
	}

	@RequiresPermissions("account:adGroup:view")
	@RequestMapping(value = "form")
	public String form(AdGroup adGroup, Model model) {
		model.addAttribute("adGroup", adGroup);
		return "modules/account/adGroupForm";
	}

	@RequiresPermissions("account:adGroup:edit")
	@RequestMapping(value = "save")
	public String save(AdGroup adGroup, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, adGroup)){
			return form(adGroup, model);
		}
		adGroupService.save(adGroup);
		addMessage(redirectAttributes, "保存企业账户成功");
		return "redirect:"+Global.getAdminPath()+"/account/adGroup/?repage";
	}
	
	@RequiresPermissions("account:adGroup:edit")
	@RequestMapping(value = "delete")
	public String delete(AdGroup adGroup, RedirectAttributes redirectAttributes) {
		adGroupService.delete(adGroup);
		addMessage(redirectAttributes, "删除企业账户成功");
		return "redirect:"+Global.getAdminPath()+"/account/adGroup/?repage";
	}

}