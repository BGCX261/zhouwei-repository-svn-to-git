package com.techstar.dmis.service;

import java.util.List;
import java.util.Collection;
import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.dmis.dto.ZdhOpexaminelistDto;

	//注册子表DAO
    import com.techstar.dmis.dto.ZdhAutoondutylogDto;
import com.techstar.dmis.dto.DdDoutageplanDto;
	

//please add your business methods start
	// to do it
//add your business method end
	
/** 
 * 业务对象服务接口类
 * @author 
 * @date
 */
public interface IZdhOpexaminelistService {

    public void addZdhOpexaminelist(ZdhOpexaminelistDto dto);

	/**
	 * 进行增加或修改操作业务处理
	 * 
	 * @param dto
	 *ZdhOpexaminelistDto 业务传输对象
	 * 
	 */
	public void saveOrUpdateZdhOpexaminelist(ZdhOpexaminelistDto dto);
	public void saveOrUpdateZdhOpexaminelist(List dtos);
	public void saveDdDoutageplan(); 
	public QueryListObj initDdDoutageplan(int beginPage,int pageSize,String sumSql);
	/**
	 * 进行加载的业务操作
	 * @param zdhOpexaminelistId
	 *            Integer 主键值ֵ
	 */
	public ZdhOpexaminelistDto loadZdhOpexaminelist(String zdhOpexaminelistId);

	/**
	 * 删除指定的业务
	 * @param zdhOpexaminelistId
	 *            Integer 主键值ֵ
	 */
	public void deleteZdhOpexaminelist(String zdhOpexaminelistId);
    /**
	* 删除指定的业务集合
	**/
	public void deleteZdhOpexaminelist(List dtos);
	
	/**
	 * 进行申请查询操作业务处理
	 */

	
	/**
	 * 进行申请查询操作业务处理(分页)
	 * 
	 * @return QueryListObj 封装了结果集及记录总数的对象
	 */
	 public QueryListObj listZdhOpexaminelist();
	 public QueryListObj listZdhOpexaminelistByHql(String hql);
	 public QueryListObj getZdhOpexaminelistByHql(String hql,int beginPage, int pageSize,String sql);

	//please add your business methods start
	// to do it
	//add your business method end

	//得到班号
	 public String getOndutyno();
	

 	//子表处理DAO
       public QueryListObj listZdhAutoondutylog();
   public void saveOrUpdateZdhAutoondutylog(ZdhAutoondutylogDto dto);
   public void deleteZdhAutoondutylog(String ondutyno);
   public ZdhAutoondutylogDto loadZdhAutoondutylog(String ondutyno);
   public QueryListObj listZdhAutoondutylogByHql(String hql);
   public void saveOrUpdateZdhAutoondutylog(List dtos);
   public void deleteZdhAutoondutylog(List dtos);
	
	   public QueryListObj listDdDoutageplan();
   public void saveOrUpdateDdDoutageplan(DdDoutageplanDto dto);
   public void deleteDdDoutageplan(String fdayplanno);
   public DdDoutageplanDto loadDdDoutageplan(String fdayplanno);
   public QueryListObj listDdDoutageplanByHql(String hql);
   public void saveOrUpdateDdDoutageplan(List dtos);
   public void deleteDdDoutageplan(List dtos);
	
	  

	//please add your business methods start
	// to do it
	//add your business method end
	
	
}
