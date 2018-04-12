package com.cars.bim.generator.service;

import com.cars.bim.generator.entity.ModelTreeEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author admin
 * @email admin@gmail.com
 * @date 2017-12-04 10:25:21
 */
public interface ModelTreeService {
	
	ModelTreeEntity queryObject(String rbimid);
	
	List<ModelTreeEntity> queryList(Map<String, Object> map);
	
	List<ModelTreeEntity> findTree(String pId);
	
	int queryTotal(Map<String, Object> map);
	
	void save(ModelTreeEntity modelTree);
	
	void update(ModelTreeEntity modelTree);
	
	void delete(String rbimid);
	
	void deleteBatch(String[] rbimids);
	
	
}
