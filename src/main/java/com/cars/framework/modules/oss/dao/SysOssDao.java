package com.cars.framework.modules.oss.dao;

import org.apache.ibatis.annotations.Mapper;

import com.cars.framework.modules.oss.entity.SysOssEntity;
import com.cars.framework.modules.sys.dao.BaseDao;

/**
 * 文件上传
 * 
 * @author framework
 * @date 2017-03-25 12:13:26
 */
@Mapper
public interface SysOssDao extends BaseDao<SysOssEntity> {
	
}
