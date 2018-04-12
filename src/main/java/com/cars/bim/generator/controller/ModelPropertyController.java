package com.cars.bim.generator.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cars.bim.generator.entity.ModelPropertyEntity;
import com.cars.bim.generator.service.ModelPropertyService;
import com.cars.framework.common.utils.PageUtils;
import com.cars.framework.common.utils.Query;
import com.cars.framework.common.utils.R;




/**
 * 
 * 
 * @author admin
 * @email admin@gmail.com
 * @date 2017-12-04 09:44:22
 */
@RestController
@RequestMapping("/generator/modelproperty")
public class ModelPropertyController {
	@Autowired
	private ModelPropertyService modelPropertyService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("generator:modelproperty:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<ModelPropertyEntity> modelPropertyList = modelPropertyService.queryList(query);
		int total = modelPropertyService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(modelPropertyList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{rbimid}")
	@RequiresPermissions("generator:modelproperty:info")
	public R info(@PathVariable("rbimid") String rbimid){
		ModelPropertyEntity modelProperty = modelPropertyService.queryObject(rbimid);
		
		return R.ok().put("modelProperty", modelProperty);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("generator:modelproperty:save")
	public R save(@RequestBody ModelPropertyEntity modelProperty){
		modelPropertyService.save(modelProperty);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("generator:modelproperty:update")
	public R update(@RequestBody ModelPropertyEntity modelProperty){
		modelPropertyService.update(modelProperty);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("generator:modelproperty:delete")
	public R delete(@RequestBody String[] rbimids){
		modelPropertyService.deleteBatch(rbimids);
		
		return R.ok();
	}
	
	/**
	 * 通过id查询
	 * @param id
	 * @return
	 */
    @RequestMapping("getModelPropertyById")
    public List<ModelPropertyEntity> get(String id){
        List<ModelPropertyEntity> list = null;
    	try{
            list = modelPropertyService.queryById(id);
        }
        catch(Exception e){
    	    e.printStackTrace();
        }
    	return list;
    }
	
}
