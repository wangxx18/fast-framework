package com.cars.bim.generator.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.cars.bim.generator.entity.ModelTreeEntity;
import com.cars.bim.generator.service.ModelTreeService;
import com.cars.framework.common.utils.PageUtils;
import com.cars.framework.common.utils.Query;
import com.cars.framework.common.utils.R;
import com.cars.framework.common.utils.StringUtil;




/**
 * 
 * 
 * @author admin
 * @email admin@gmail.com
 * @date 2017-12-04 10:25:21
 */
@RestController
@RequestMapping("/generator/modeltree")
public class ModelTreeController {
	@Autowired
	private ModelTreeService modelTreeService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("generator:modeltree:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<ModelTreeEntity> modelTreeList = modelTreeService.queryList(query);
		int total = modelTreeService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(modelTreeList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{rbimid}")
	@RequiresPermissions("generator:modeltree:info")
	public R info(@PathVariable("rbimid") String rbimid){
		ModelTreeEntity modelTree = modelTreeService.queryObject(rbimid);
		
		return R.ok().put("modelTree", modelTree);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("generator:modeltree:save")
	public R save(@RequestBody ModelTreeEntity modelTree){
		modelTreeService.save(modelTree);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("generator:modeltree:update")
	public R update(@RequestBody ModelTreeEntity modelTree){
		modelTreeService.update(modelTree);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("generator:modeltree:delete")
	public R delete(@RequestBody String[] rbimids){
		modelTreeService.deleteBatch(rbimids);
		
		return R.ok();
	}
    /**
     * 返回以参数为父节点的集合
     * @return
     */
    @RequestMapping("/findTree")
    public  String findTree(String id){
    	
    	List<ModelTreeEntity> findTree = new ArrayList<ModelTreeEntity>();
    	
    	if(StringUtil.isEmpty(id)){
    		id="0";
    		findTree =	modelTreeService.findTree(id);
    		ModelTreeEntity en = new ModelTreeEntity();
        	en.setRbimid("0");
        	en.setName("清河站");
        	findTree.add(en);
    	}else
    	{
    		findTree =	modelTreeService.findTree(id);
    	}
    	
    	
    	
    	
    	System.out.println("====================="+JSON.toJSONString(findTree));
    	return JSON.toJSONString(findTree);
    	
    	
    }
  
}
