package com.cars.bim.generator.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.cars.bim.generator.dao.TbLeaveDao;
import com.cars.bim.generator.entity.TbLeaveEntity;
import com.cars.bim.generator.service.TbLeaveService;
import com.fasterxml.jackson.annotation.ObjectIdGenerators.UUIDGenerator;
import com.fasterxml.jackson.databind.deser.std.UUIDDeserializer;



@Service("tbLeaveService")
public class TbLeaveServiceImpl implements TbLeaveService {
	@Autowired
	private TbLeaveDao tbLeaveDao;
	
	@Override
	public TbLeaveEntity queryObject(String id){
		return tbLeaveDao.queryObject(id);
	}
	
	@Override
	public List<TbLeaveEntity> queryList(Map<String, Object> map){
		return tbLeaveDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return tbLeaveDao.queryTotal(map);
	}
	
	@Override
	public void save(TbLeaveEntity tbLeave){
		tbLeaveDao.save(tbLeave);
	}
	
	@Override
	public void update(TbLeaveEntity tbLeave){
		tbLeaveDao.update(tbLeave);
	}
	
	@Override
	public void delete(String id){
		tbLeaveDao.delete(id);
	}
	
	@Override
	public void deleteBatch(String[] ids){
		tbLeaveDao.deleteBatch(ids);
	}
	
}
