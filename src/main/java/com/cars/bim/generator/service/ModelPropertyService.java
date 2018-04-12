package com.cars.bim.generator.service;

import com.cars.bim.generator.entity.ModelPropertyEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author admin
 * @email admin@gmail.com
 * @date 2017-12-04 09:44:22
 */
public interface ModelPropertyService {
	
	ModelPropertyEntity queryObject(String rbimid);
	
	List<ModelPropertyEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(ModelPropertyEntity modelProperty);
	
	void update(ModelPropertyEntity modelProperty);
	
	void delete(String rbimid);
	
	void deleteBatch(String[] rbimids);
	
	List<ModelPropertyEntity> queryById(String id);
	
}
