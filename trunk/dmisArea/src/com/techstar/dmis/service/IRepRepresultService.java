package com.techstar.dmis.service;

import java.util.List;
import java.util.Collection;
import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.dmis.dto.RepRepresultDto;

	//注册子表DAO
    import com.techstar.dmis.dto.RepTree2resultDto;
	import com.techstar.dmis.dto.RepReptemplateDto;
	import com.techstar.dmis.dto.RepResdataDto;
	

//please add your business methods start
	// to do it
//add your business method end
	
/** 
 * 业务对象服务接口类
 * @author 
 * @date
 */
public interface IRepRepresultService {

    public void addRepRepresult(RepRepresultDto dto);

	/**
	 * 进行增加或修改操作业务处理
	 * 
	 * @param dto
	 *RepRepresultDto 业务传输对象
	 * 
	 */
	public void saveOrUpdateRepRepresult(RepRepresultDto dto);
	public void saveOrUpdateRepRepresult(List dtos);

	/**
	 * 进行加载的业务操作
	 * @param repRepresultId
	 *            Integer 主键值ֵ
	 */
	public RepRepresultDto loadRepRepresult(String repRepresultId);

	/**
	 * 删除指定的业务
	 * @param repRepresultId
	 *            Integer 主键值ֵ
	 */
	public void deleteRepRepresult(String repRepresultId);
    /**
	* 删除指定的业务集合
	**/
	public void deleteRepRepresult(List dtos);
	
	/**
	 * 进行申请查询操作业务处理
	 */

	
	/**
	 * 进行申请查询操作业务处理(分页)
	 * 
	 * @return QueryListObj 封装了结果集及记录总数的对象
	 */
	 public QueryListObj listRepRepresult();
	 public QueryListObj listRepRepresultByHql(String hql);
	 public QueryListObj getRepRepresultByHql(String hql,int beginPage, int pageSize,String sql);

	//please add your business methods start
	// to do it
	//add your business method end

	
	

 	//子表处理DAO
       public QueryListObj listRepTree2result();
   public void saveOrUpdateRepTree2result(RepTree2resultDto dto);
   public void deleteRepTree2result(String f_relationid);
   public RepTree2resultDto loadRepTree2result(String f_relationid);
   public QueryListObj listRepTree2resultByHql(String hql);
   public void saveOrUpdateRepTree2result(List dtos);
   public void deleteRepTree2result(List dtos);
	
	   public QueryListObj listRepReptemplate();
   public void saveOrUpdateRepReptemplate(RepReptemplateDto dto);
   public void deleteRepReptemplate(String f_reptmplid);
   public RepReptemplateDto loadRepReptemplate(String f_reptmplid);
   public QueryListObj listRepReptemplateByHql(String hql);
   public void saveOrUpdateRepReptemplate(List dtos);
   public void deleteRepReptemplate(List dtos);
	
	   public QueryListObj listRepResdata();
   public void saveOrUpdateRepResdata(RepResdataDto dto);
   public void deleteRepResdata(String res_id);
   public RepResdataDto loadRepResdata(String res_id);
   public QueryListObj listRepResdataByHql(String hql);
   public void saveOrUpdateRepResdata(List dtos);
   public void deleteRepResdata(List dtos);
	
	  

	//please add your business methods start
	// to do it
	//add your business method end
	
	
}
