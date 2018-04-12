package com.cars.bim.generator.service;

import com.cars.bim.generator.entity.TbOvertimeEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author admin
 * @email admin@gmail.com
 * @date 2018-04-12 10:38:36
 */
public interface TbOvertimeService {
	
	TbOvertimeEntity queryObject(String id);
	
	List<TbOvertimeEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(TbOvertimeEntity tbOvertime);
	
	void update(TbOvertimeEntity tbOvertime);
	
	void delete(String id);
	
	void deleteBatch(String[] ids);
}
