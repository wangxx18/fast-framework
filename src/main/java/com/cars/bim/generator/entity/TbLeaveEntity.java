package com.cars.bim.generator.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 
 * 
 * @author admin
 * @email admin@gmail.com
 * @date 2018-04-12 10:38:35
 */
public class TbLeaveEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long id;
	//
	private String userId;
	//
	private String beginDate;
	//
	private String endDate;
	//
	private Double totalDate;
	//备注
	private String beizhu;
	//
	private String createDate;
	//
	private Integer status;

	/**
	 * 设置：
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Long getId() {
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
	 * 设置：
	 */
	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}
	/**
	 * 获取：
	 */
	public String getBeginDate() {
		return beginDate;
	}
	/**
	 * 设置：
	 */
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	/**
	 * 获取：
	 */
	public String getEndDate() {
		return endDate;
	}
	/**
	 * 设置：
	 */
	public void setTotalDate(Double totalDate) {
		this.totalDate = totalDate;
	}
	/**
	 * 获取：
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
	 * 设置：
	 */
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	/**
	 * 获取：
	 */
	public String getCreateDate() {
		return createDate;
	}
	/**
	 * 设置：
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：
	 */
	public Integer getStatus() {
		return status;
	}
}
