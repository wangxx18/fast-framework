package com.cars.bim.generator.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.cars.bim.generator.dao.ModelTreeDao;
import com.cars.bim.generator.entity.ModelTreeEntity;
import com.cars.bim.generator.service.ModelTreeService;



@Service("modelTreeService")
public class ModelTreeServiceImpl implements ModelTreeService {
	@Autowired
	private ModelTreeDao modelTreeDao;
	
	@Override
	public ModelTreeEntity queryObject(String rbimid){
		return modelTreeDao.queryObject(rbimid);
	}
	
	@Override
	public List<ModelTreeEntity> queryList(Map<String, Object> map){
		return modelTreeDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return modelTreeDao.queryTotal(map);
	}
	
	@Override
	public void save(ModelTreeEntity modelTree){
		modelTreeDao.save(modelTree);
	}
	
	@Override
	public void update(ModelTreeEntity modelTree){
		modelTreeDao.update(modelTree);
	}
	
	@Override
	public void delete(String rbimid){
		modelTreeDao.delete(rbimid);
	}
	
	@Override
	public void deleteBatch(String[] rbimids){
		modelTreeDao.deleteBatch(rbimids);
	}

	@Override
	public List<ModelTreeEntity> findTree(String pId) {
		// TODO Auto-generated method stub
		return modelTreeDao.findTree(pId);
	}
	
}
