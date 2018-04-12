package com.cars.bim.generator.controller;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cars.bim.generator.entity.ModelPropertyEntity;
import com.cars.bim.generator.entity.ModelTreeEntity;
import com.cars.bim.generator.service.ModelPropertyService;
import com.cars.bim.generator.service.ModelTreeService;


@Controller
@RequestMapping("modelData")
public class ModelDataTools {
	@Autowired
	private ModelTreeService mms;
	@Autowired
	private ModelPropertyService modelPropertyService;
	
	/**
	 * 生成modelMapping数据
	 * @return
	 */
	@RequestMapping("/creatModelTreeData")
	@ResponseBody
	public List<ModelTreeEntity> creatModelTreeData(String dbName){
		String dataUrl ="jdbc:sqlite:D:/qinghezhan/jg/";
	/*	List modelType = new ArrayList();
        modelType.add("A1");
        modelType.add("A2");
        modelType.add("A3");
        modelType.add("A4");
        modelType.add("A5");
        modelType.add("A6");
        modelType.add("B1");
        modelType.add("B2");
        modelType.add("K");
        */
		 List<ModelTreeEntity> list=new ArrayList<ModelTreeEntity>();
		// 加载驱动  
		String modelName ="";
		String modelNameStr = "";
		String mileage ="";
		int mileageInt = 0;
		String ringNum ="";
        try {  
            Class.forName("org.sqlite.JDBC");  
        } catch (ClassNotFoundException e) {   
            // e.printStackTrace();  
            System.out.println("数据库驱动未找到!");  
        }  
        
        // 得到连接 会在你所填写的目录建一个你命名的文件数据库  
        Connection conn;  
        try {  
            conn = DriverManager.getConnection(dataUrl+dbName,null,null);  
            // 设置自动提交为false  
            conn.setAutoCommit(false);  
            Statement stmt = conn.createStatement();  
              
            
            // 得到结果集  
            String sql ="with cte as ( select rbimid,parentrbimid,name,isleafnode, 0 as lvl "
            		+ "from model_tree where parentrbimid='0' "
            		+ "union all select d.rbimid,d.parentrbimid,d.name,d.isleafnode,"
            		+ "lvl + 1 from cte c inner join model_tree d on  d.parentrbimid = c.rbimid )"
            		+ " select * from cte";
            
            ResultSet rs = stmt.executeQuery(sql);  
            DecimalFormat df = new DecimalFormat("0.000");
            while (rs.next()) {  
            	ModelTreeEntity mm=new ModelTreeEntity();
            	mm.setRbimid(rs.getString("rbimid"));
            	mm.setParentrbimid(rs.getString("parentrbimid"));
            	
            	mm.setIsParent(rs.getString("isleafnode"));
            	mm.setName(rs.getString("name"));
         /*   	if("1".equals(rs.getString("lvl"))){
            		mileage = rs.getString("name").split(" ")[1];//里程
            		mileageInt = Integer.parseInt(mileage)+1; //轻量化问题需要+1米
                	ringNum = getRingByDistance(mileageInt+"")+"";
            		modelName =mileageInt+"";
            		modelNameStr =  df.format(Double.parseDouble(modelName)/1000);
            		modelName = "DK"+modelNameStr.split("\\.")[0]+"+"+modelNameStr.split("\\.")[1];
            		mm.setMileage(mileageInt+"");
            		mm.setName(modelName+"("+ringNum+")");
            		mm.setRingNum(ringNum);
            		
            		if(mileageInt>=CommonConstants.DG_DISTANCE_START_1
                			&&mileageInt<=CommonConstants.DG_DISTANCE_END_1){
                		mm.setTsId("1");
                	}else{
                		mm.setTsId("2");
                	}
            		
            	}else if("1".equals(rs.getString("isleafnode"))){//根节点 为构件
            		if("4".equals(rs.getString("lvl"))){
            			if(!modelType.contains(getProperty(rs.getString("rbimid"),"level",dataUrl+dbName))){
            				if("1".equals(getProperty(rs.getString("rbimid"),"level",dataUrl+dbName))){
                				mm.setName("中箱涵");	
                			}else if("2".equals(getProperty(rs.getString("rbimid"),"level",dataUrl+dbName))){
                				mm.setName("左箱涵");	
                			}else if("3".equals(getProperty(rs.getString("rbimid"),"level",dataUrl+dbName))){
                				mm.setName("右箱涵");	
                			}else{
                				mm.setName(getProperty(rs.getString("rbimid"),"level",dataUrl+dbName));
                			}
            			}else{
            				mm.setName(getProperty(rs.getString("rbimid"),"level",dataUrl+dbName));	
            			}
            		}else{
            			mm.setName(getProperty(rs.getString("rbimid"),"level",dataUrl+dbName));	
            		}
            		
            	}else if("0".equals(rs.getString("isleafnode"))&&("2".equals(rs.getString("lvl"))||"3".equals(rs.getString("lvl"))||"4".equals(rs.getString("lvl")))){
            		mm.setName(rs.getString("name").substring(4));
            	}else{
            		mm.setName(rs.getString("name"));
            	}*/
            	mms.save(mm);
            	//list.add(mm);
            }  
            rs.close();  
            conn.close();  
        } catch (SQLException e) {  
             e.printStackTrace();  
            System.out.println("SQL异常!");  
        } 
        return list;
	}
	
	/**
	 * 提取属性sql
	 * @return
	 */
	@RequestMapping("/creatModelPropertyData")
	@ResponseBody
	public String createData(String dbName){
		String dataUrl ="jdbc:sqlite:D:/qinghezhan/jg/";
		// 加载驱动  
        try {  
            Class.forName("org.sqlite.JDBC");  
        } catch (ClassNotFoundException e) {   
            // e.printStackTrace();  
            System.out.println("数据库驱动未找到!");  
        }  
        // 得到连接 会在你所填写的目录建一个你命名的文件数据库  
        Connection conn;  
        try {  
            conn = DriverManager.getConnection(dataUrl+dbName,null,null);  
            // 设置自动提交为false  
            conn.setAutoCommit(false);  
            Statement stmt = conn.createStatement();  
              
            
            // 得到结果集  
            
            String sql="WITH cte AS ( SELECT rbimid FROM model_tree WHERE parentrbimid = '0'"
					    +"UNION ALL"
					   +" SELECT d.rbimid"
					    +"  FROM cte c"
					    +"       INNER JOIN"
					    +"       model_tree d ON  d.parentrbimid = c.rbimid"
					+")"
					+"SELECT y.rbimid,"
					+"       y.name,"
					+"       y.value,"
					+"       y.unit"
					+"  FROM model_property y"
					+" WHERE y.rbimid IN ("
					+"           SELECT *"
					+"             FROM cte     )";
					
            
            ResultSet rs = stmt.executeQuery(sql);  
            while (rs.next()) {  
            	ModelPropertyEntity modelProperty=new ModelPropertyEntity();
            	modelProperty.setRbimid(rs.getString("rbimid"));
            	modelProperty.setValue(rs.getString("value"));
            	modelProperty.setName(rs.getString("name"));
            	modelProperty.setUnit(rs.getString("unit"));
            	modelPropertyService.save(modelProperty);
            }  
            rs.close();  
            conn.close();  
        } catch (SQLException e) {  
             e.printStackTrace(); 
            System.out.println("SQL异常!");  
            return "false";
        } 
        return "ture";
	}
	public String getProperty(String rbimid,String propertyName,String dataUrl){
		// 加载驱动  
		String returnLevelName ="";
		try {  
			Class.forName("org.sqlite.JDBC");  
		} catch (ClassNotFoundException e) {   
			// e.printStackTrace();  
			System.out.println("数据库驱动未找到!");  
		}  
		// 得到连接 会在你所填写的目录建一个你命名的文件数据库  
		Connection conn;  
		try {  
			conn = DriverManager.getConnection(dataUrl,null,null);  
			// 设置自动提交为false  
			conn.setAutoCommit(false);  
			Statement stmt = conn.createStatement();  
			
			// 得到结果集  
    		
			String sql ="SELECT DISTINCT value from model_property t where t.rbimid ='"+rbimid+"'"
    		 		+ "and name='"+propertyName+"'";
			
			ResultSet rs = stmt.executeQuery(sql);  
			while (rs.next()) {  
				returnLevelName = rs.getString("value");
			}  
			rs.close();  
			conn.close();  
		} catch (SQLException e) {  
			e.printStackTrace(); 
			System.out.println("SQL异常!");  
			return "false";
		} 
		return returnLevelName;
	}
	
}
