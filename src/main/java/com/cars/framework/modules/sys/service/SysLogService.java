package com.cars.framework.modules.sys.service;

import java.util.List;
import java.util.Map;

import com.cars.framework.modules.sys.entity.SysLogEntity;

/**
 * 系统日志
 * 
 * @author framework
 * @date 2017-03-08 10:40:56
 */
public interface SysLogService {
	
	SysLogEntity queryObject(Long id);
	
	List<SysLogEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(SysLogEntity sysLog);

	void delete(Long id);
	
	void deleteBatch(Long[] ids);
}
