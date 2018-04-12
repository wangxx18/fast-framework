package com.cars.framework.dynamicdatasource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cars.framework.dynamicdatasource.annotation.DataSource;
import com.cars.framework.modules.api.entity.UserEntity;
import com.cars.framework.modules.api.service.UserService;

/**
 * 测试
 * @author framework
 * @date 2017/9/16 23:10
 */
@Service
public class DataSourceTestService {
    @Autowired
    private UserService userService;

    public UserEntity queryObject(Long userId){
        return userService.queryObject(userId);
    }

    @DataSource(name = DataSourceContext.SECOND)
    public UserEntity queryObject2(Long userId){
        return userService.queryObject(userId);
    }
}
