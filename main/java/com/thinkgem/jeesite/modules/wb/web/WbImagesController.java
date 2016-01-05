/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.wb.web;

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
import com.thinkgem.jeesite.modules.wb.entity.WbImages;
import com.thinkgem.jeesite.modules.wb.service.WbImagesService;

/**
 * 鸟图片库Controller
 * @author willie
 * @version 2015-12-03
 */
@Controller
@RequestMapping(value = "${adminPath}/wb/wbImages")
public class WbImagesController extends BaseController {

	@Autowired
	private WbImagesService wbImagesService;
	
	@ModelAttribute
	public WbImages get(@RequestParam(required=false) String id) {
		WbImages entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = wbImagesService.get(id);
		}
		if (entity == null){
			entity = new WbImages();
		}
		return entity;
	}
	
	@RequiresPermissions("wb:wbImages:view")
	@RequestMapping(value = {"list", ""})
	public String list(WbImages wbImages, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<WbImages> page = wbImagesService.findPage(new Page<WbImages>(request, response), wbImages); 
		model.addAttribute("page", page);
		return "modules/wb/wbImagesList";
	}

	@RequiresPermissions("wb:wbImages:view")
	@RequestMapping(value = "form")
	public String form(WbImages wbImages, Model model) {
		model.addAttribute("wbImages", wbImages);
		return "modules/wb/wbImagesForm";
	}

	@RequiresPermissions("wb:wbImages:edit")
	@RequestMapping(value = "save")
	public String save(WbImages wbImages, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, wbImages)){
			return form(wbImages, model);
		}
		wbImagesService.save(wbImages);
		addMessage(redirectAttributes, "保存鸟图片库成功");
		return "redirect:"+Global.getAdminPath()+"/wb/wbImages/?repage";
	}
	
	@RequiresPermissions("wb:wbImages:edit")
	@RequestMapping(value = "delete")
	public String delete(WbImages wbImages, RedirectAttributes redirectAttributes) {
		wbImagesService.delete(wbImages);
		addMessage(redirectAttributes, "删除鸟图片库成功");
		return "redirect:"+Global.getAdminPath()+"/wb/wbImages/?repage";
	}

}