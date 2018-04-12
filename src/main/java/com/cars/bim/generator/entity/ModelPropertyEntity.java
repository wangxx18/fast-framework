package com.cars.bim.generator.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 
 * 
 * @author admin
 * @email admin@gmail.com
 * @date 2017-12-04 09:44:22
 */
public class ModelPropertyEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private String rbimid;
	//
	private String name;
	//
	private String value;
	//
	private String unit;

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
	public void setValue(String value) {
		this.value = value;
	}
	/**
	 * 获取：
	 */
	public String getValue() {
		return value;
	}
	/**
	 * 设置：
	 */
	public void setUnit(String unit) {
		this.unit = unit;
	}
	/**
	 * 获取：
	 */
	public String getUnit() {
		return unit;
	}
}
