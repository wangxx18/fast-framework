package com.cars.framework.modules.api.dao;

import org.apache.ibatis.annotations.Mapper;

import com.cars.framework.modules.api.entity.UserEntity;
import com.cars.framework.modules.sys.dao.BaseDao;

/**
 * 用户
 * 
 * @author framework
 * @date 2017-03-23 15:22:06
 */
@Mapper
public interface UserDao extends BaseDao<UserEntity> {

    UserEntity queryByMobile(String mobile);
}
