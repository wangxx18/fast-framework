package com.cars.bim.generator.dao;

import com.cars.bim.generator.entity.ModelTreeEntity;
import com.cars.framework.modules.sys.dao.BaseDao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * 
 * @author admin
 * @email admin@gmail.com
 * @date 2017-12-04 10:25:21
 */
@Mapper
public interface ModelTreeDao extends BaseDao<ModelTreeEntity> {
	List<ModelTreeEntity> findTree(String pId);
}
