package com.cars.bim.generator.dao;

import com.cars.bim.generator.entity.ModelPropertyEntity;
import com.cars.framework.modules.sys.dao.BaseDao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * 
 * @author admin
 * @email admin@gmail.com
 * @date 2017-12-04 09:44:22
 */
@Mapper
public interface ModelPropertyDao extends BaseDao<ModelPropertyEntity> {
	List<ModelPropertyEntity> queryById(String id);
}
