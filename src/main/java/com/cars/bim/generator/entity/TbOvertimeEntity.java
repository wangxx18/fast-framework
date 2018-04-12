package com.cars.bim.generator.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 
 * 
 * @author admin
 * @email admin@gmail.com
 * @date 2018-04-12 10:38:36
 */
public class TbOvertimeEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private String id;
	//
	private String userId;
	//开始时间
	private Date beginDate;
	//加班总时长
	private Double totalDate;
	//备注
	private String beizhu;
	//创建时间
	private Date createDate;

	/**
	 * 设置：
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public String getId() {
		return id;
	}
	/**
	 * 设置：
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * 获取：
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * 设置：开始时间
	 */
	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}
	/**
	 * 获取：开始时间
	 */
	public Date getBeginDate() {
		return beginDate;
	}
	/**
	 * 设置：加班总时长
	 */
	public void setTotalDate(Double totalDate) {
		this.totalDate = totalDate;
	}
	/**
	 * 获取：加班总时长
	 */
	public Double getTotalDate() {
		return totalDate;
	}
	/**
	 * 设置：备注
	 */
	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}
	/**
	 * 获取：备注
	 */
	public String getBeizhu() {
		return beizhu;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreateDate() {
		return createDate;
	}
}
