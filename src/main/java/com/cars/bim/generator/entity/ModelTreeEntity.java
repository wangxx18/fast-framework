package com.cars.bim.generator.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 
 * 
 * @author admin
 * @email admin@gmail.com
 * @date 2017-12-04 10:25:21
 */
public class ModelTreeEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private String rbimid;
	//
	private String parentrbimid;
	//
	private String name;
	//
	private String isParent;

	/**
	 * 设置：
	 */
	public void setRbimid(String rbimid) {
		this.rbimid = rbimid;
	}
	/**
	 * 获取：
	 */
	public String getRbimid() {
		return rbimid;
	}
	/**
	 * 设置：
	 */
	public void setParentrbimid(String parentrbimid) {
		this.parentrbimid = parentrbimid;
	}
	/**
	 * 获取：
	 */
	public String getParentrbimid() {
		return parentrbimid;
	}
	/**
	 * 设置：
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：
	 */
	public void setIsParent(String isParent) {
		this.isParent = isParent;
	}
	/**
	 * 获取：
	 */
	public String getIsParent() {
		return isParent;
	}
}
