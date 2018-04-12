package com.cars.framework.modules.job.dao;

import org.apache.ibatis.annotations.Mapper;

import com.cars.framework.modules.job.entity.ScheduleJobLogEntity;
import com.cars.framework.modules.sys.dao.BaseDao;

/**
 * 定时任务日志
 * 
 * @author framework
 * @date 2016年12月1日 下午10:30:02
 */
@Mapper
public interface ScheduleJobLogDao extends BaseDao<ScheduleJobLogEntity> {
	
}
