package com.cars.bim.generator.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.cars.bim.generator.dao.ModelPropertyDao;
import com.cars.bim.generator.entity.ModelPropertyEntity;
import com.cars.bim.generator.service.ModelPropertyService;



@Service("modelPropertyService")
public class ModelPropertyServiceImpl implements ModelPropertyService {
	@Autowired
	private ModelPropertyDao modelPropertyDao;
	
	@Override
	public ModelPropertyEntity queryObject(String rbimid){
		return modelPropertyDao.queryObject(rbimid);
	}
	
	@Override
	public List<ModelPropertyEntity> queryList(Map<String, Object> map){
		return modelPropertyDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return modelPropertyDao.queryTotal(map);
	}
	
	@Override
	public void save(ModelPropertyEntity modelProperty){
		modelPropertyDao.save(modelProperty);
	}
	
	@Override
	public void update(ModelPropertyEntity modelProperty){
		modelPropertyDao.update(modelProperty);
	}
	
	@Override
	public void delete(String rbimid){
		modelPropertyDao.delete(rbimid);
	}
	
	@Override
	public void deleteBatch(String[] rbimids){
		modelPropertyDao.deleteBatch(rbimids);
	}

	@Override
	public List<ModelPropertyEntity> queryById(String id) {
		// TODO Auto-generated method stub
		return modelPropertyDao.queryById(id);
	}
	
}
