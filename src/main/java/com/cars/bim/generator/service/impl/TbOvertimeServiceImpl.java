package com.cars.bim.generator.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.cars.bim.generator.dao.TbOvertimeDao;
import com.cars.bim.generator.entity.TbOvertimeEntity;
import com.cars.bim.generator.service.TbOvertimeService;



@Service("tbOvertimeService")
public class TbOvertimeServiceImpl implements TbOvertimeService {
	@Autowired
	private TbOvertimeDao tbOvertimeDao;
	
	@Override
	public TbOvertimeEntity queryObject(String id){
		return tbOvertimeDao.queryObject(id);
	}
	
	@Override
	public List<TbOvertimeEntity> queryList(Map<String, Object> map){
		return tbOvertimeDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return tbOvertimeDao.queryTotal(map);
	}
	
	@Override
	public void save(TbOvertimeEntity tbOvertime){
		tbOvertimeDao.save(tbOvertime);
	}
	
	@Override
	public void update(TbOvertimeEntity tbOvertime){
		tbOvertimeDao.update(tbOvertime);
	}
	
	@Override
	public void delete(String id){
		tbOvertimeDao.delete(id);
	}
	
	@Override
	public void deleteBatch(String[] ids){
		tbOvertimeDao.deleteBatch(ids);
	}
	
}
