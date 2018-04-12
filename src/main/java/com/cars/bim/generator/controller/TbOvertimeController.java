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

import com.cars.bim.generator.entity.TbOvertimeEntity;
import com.cars.bim.generator.service.TbOvertimeService;
import com.cars.framework.common.utils.PageUtils;
import com.cars.framework.common.utils.Query;
import com.cars.framework.common.utils.R;




/**
 * 
 * 
 * @author admin
 * @email admin@gmail.com
 * @date 2018-04-12 10:38:36
 */
@RestController
@RequestMapping("/generator/tbovertime")
public class TbOvertimeController {
	@Autowired
	private TbOvertimeService tbOvertimeService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("generator:tbovertime:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<TbOvertimeEntity> tbOvertimeList = tbOvertimeService.queryList(query);
		int total = tbOvertimeService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(tbOvertimeList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("generator:tbovertime:info")
	public R info(@PathVariable("id") String id){
		TbOvertimeEntity tbOvertime = tbOvertimeService.queryObject(id);
		
		return R.ok().put("tbOvertime", tbOvertime);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("generator:tbovertime:save")
	public R save(@RequestBody TbOvertimeEntity tbOvertime){
		tbOvertimeService.save(tbOvertime);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("generator:tbovertime:update")
	public R update(@RequestBody TbOvertimeEntity tbOvertime){
		tbOvertimeService.update(tbOvertime);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("generator:tbovertime:delete")
	public R delete(@RequestBody String[] ids){
		tbOvertimeService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
