package com.cars.bim.generator.service;

import com.cars.bim.generator.entity.TbLeaveEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author admin
 * @email admin@gmail.com
 * @date 2018-04-12 10:38:35
 */
public interface TbLeaveService {
	
	TbLeaveEntity queryObject(String id);
	
	List<TbLeaveEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(TbLeaveEntity tbLeave);
	
	void update(TbLeaveEntity tbLeave);
	
	void delete(String id);
	
	void deleteBatch(String[] ids);
}
