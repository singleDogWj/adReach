/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.wb.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 鸟图片库Entity
 * @author willie
 * @version 2015-12-03
 */
public class WbImages extends DataEntity<WbImages> {
	
	private static final long serialVersionUID = 1L;
	private String name;		// name
	private String image;		// 图片
	private String sort;		// 排序
	private String description;		// 描述
	private String birdId;		// 鸟编号
	
	public WbImages() {
		super();
	}

	public WbImages(String id){
		super(id);
	}

	@Length(min=0, max=100, message="name长度必须介于 0 和 100 之间")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Length(min=0, max=1000, message="图片长度必须介于 0 和 1000 之间")
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}
	
	@Length(min=0, max=255, message="描述长度必须介于 0 和 255 之间")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@Length(min=1, max=64, message="鸟编号长度必须介于 1 和 64 之间")
	public String getBirdId() {
		return birdId;
	}

	public void setBirdId(String birdId) {
		this.birdId = birdId;
	}
	
}