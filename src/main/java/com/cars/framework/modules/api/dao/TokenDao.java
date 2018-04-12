package com.cars.framework.modules.api.dao;

import org.apache.ibatis.annotations.Mapper;

import com.cars.framework.modules.api.entity.TokenEntity;
import com.cars.framework.modules.sys.dao.BaseDao;

/**
 * 用户Token
 * 
 * @author framework
 * @date 2017-03-23 15:22:07
 */
@Mapper
public interface TokenDao extends BaseDao<TokenEntity> {
    
    TokenEntity queryByUserId(Long userId);

    TokenEntity queryByToken(String token);
	
}
