package com.cars.framework.modules.sys.dao;

import org.apache.ibatis.annotations.Mapper;

import com.cars.framework.modules.sys.entity.SysLogEntity;

/**
 * 系统日志
 * 
 * @author framework
 * @date 2017-03-08 10:40:56
 */
@Mapper
public interface SysLogDao extends BaseDao<SysLogEntity> {
	
}
