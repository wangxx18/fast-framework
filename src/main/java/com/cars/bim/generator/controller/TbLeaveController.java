package com.cars.bim.generator.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cars.bim.generator.entity.TbLeaveEntity;
import com.cars.bim.generator.service.TbLeaveService;
import com.cars.framework.common.utils.PageUtils;
import com.cars.framework.common.utils.Query;
import com.cars.framework.common.utils.R;




/**
 * 
 * 
 * @author admin
 * @email admin@gmail.com
 * @date 2018-04-12 10:38:35
 */
@RestController
@RequestMapping("/generator/tbleave")
public class TbLeaveController {
	@Autowired
	private TbLeaveService tbLeaveService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
// @RequiresPermissions("generator:tbleave:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<TbLeaveEntity> tbLeaveList = tbLeaveService.queryList(query);
		int total = tbLeaveService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(tbLeaveList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	//	@RequiresPermissions("generator:tbleave:info")
	public R info(@PathVariable("id") String id){
		TbLeaveEntity tbLeave = tbLeaveService.queryObject(id);
		
		return R.ok().put("tbLeave", tbLeave);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	//	@RequiresPermissions("generator:tbleave:save")
	public R save(@RequestBody TbLeaveEntity tbLeave){
		tbLeaveService.save(tbLeave);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	// @RequiresPermissions("generator:tbleave:update")
	public R update(@RequestBody TbLeaveEntity tbLeave){
		tbLeaveService.update(tbLeave);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("generator:tbleave:delete")
	public R delete(@RequestBody String[] ids){
		tbLeaveService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
