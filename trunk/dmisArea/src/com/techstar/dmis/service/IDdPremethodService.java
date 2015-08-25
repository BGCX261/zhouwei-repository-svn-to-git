package com.techstar.dmis.service;

import java.util.List;
import java.util.Collection;
import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.dmis.dto.DdPremethodDto;

	//注册子表DAO
    import com.techstar.dmis.dto.DdMoutageplanDto;
	import com.techstar.dmis.dto.DdEnsuringpsmanageDto;
	

//please add your business methods start
	// to do it
//add your business method end
	
/** 
 * 业务对象服务接口类
 * @author 
 * @date
 */
public interface IDdPremethodService {

    public void addDdPremethod(DdPremethodDto dto);

	/**
	 * 进行增加或修改操作业务处理
	 * 
	 * @param dto
	 *DdPremethodDto 业务传输对象
	 * 
	 */
	public void saveOrUpdateDdPremethod(DdPremethodDto dto);
	public void saveOrUpdateDdPremethod(List dtos);
	
	
	public QueryListObj listDdPremethodByHQL(String hql);

	/**
	 * 进行加载的业务操作
	 * @param ddPremethodId
	 *            Integer 主键值ֵ
	 */
	public DdPremethodDto loadDdPremethod(String ddPremethodId);

	/**
	 * 删除指定的业务
	 * @param ddPremethodId
	 *            Integer 主键值ֵ
	 */
	public void deleteDdPremethod(String ddPremethodId);
    /**
	* 删除指定的业务集合
	**/
	public void deleteDdPremethod(List dtos);
	
	/**
	 * 进行申请查询操作业务处理
	 */

	
	/**
	 * 进行申请查询操作业务处理(分页)
	 * 
	 * @return QueryListObj 封装了结果集及记录总数的对象
	 */
	 public QueryListObj listDdPremethod();
	 public QueryListObj listDdPremethodByHql(String hql);
	 public QueryListObj getDdPremethodByHql(String hql,int beginPage, int pageSize,String sql);

	//please add your business methods start
	// to do it
	//add your business method end

	
	

 	//子表处理DAO
       public QueryListObj listDdMoutageplan();
   public void saveOrUpdateDdMoutageplan(DdMoutageplanDto dto);
   public void deleteDdMoutageplan(String fmonthplanno);
   public DdMoutageplanDto loadDdMoutageplan(String fmonthplanno);
   public QueryListObj listDdMoutageplanByHql(String hql);
   public void saveOrUpdateDdMoutageplan(List dtos);
   public void deleteDdMoutageplan(List dtos);
	
	   public QueryListObj listDdEnsuringpsmanage();
   public void saveOrUpdateDdEnsuringpsmanage(DdEnsuringpsmanageDto dto);
   public void deleteDdEnsuringpsmanage(String fid);
   public DdEnsuringpsmanageDto loadDdEnsuringpsmanage(String fid);
   public QueryListObj listDdEnsuringpsmanageByHql(String hql);
   public void saveOrUpdateDdEnsuringpsmanage(List dtos);
   public void deleteDdEnsuringpsmanage(List dtos);
	
	  

	//please add your business methods start
	// to do it
	//add your business method end
	
	
}
