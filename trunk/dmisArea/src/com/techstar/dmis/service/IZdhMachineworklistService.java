package com.techstar.dmis.service;

import java.util.List;
import java.util.Collection;
import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.dmis.dto.ZdhMachineworklistDto;

	//注册子表DAO
    import com.techstar.dmis.dto.ZdhAutoondutylogDto;
	

//please add your business methods start
	// to do it
//add your business method end
	
/** 
 * 业务对象服务接口类
 * @author 
 * @date
 */
public interface IZdhMachineworklistService {

    public void addZdhMachineworklist(ZdhMachineworklistDto dto);

	/**
	 * 进行增加或修改操作业务处理
	 * 
	 * @param dto
	 *ZdhMachineworklistDto 业务传输对象
	 * 
	 */
	public void saveOrUpdateZdhMachineworklist(ZdhMachineworklistDto dto);
	public void saveOrUpdateZdhMachineworklist(List dtos);

	/**
	 * 进行加载的业务操作
	 * @param zdhMachineworklistId
	 *            Integer 主键值ֵ
	 */
	public ZdhMachineworklistDto loadZdhMachineworklist(String zdhMachineworklistId);

	/**
	 * 删除指定的业务
	 * @param zdhMachineworklistId
	 *            Integer 主键值ֵ
	 */
	public void deleteZdhMachineworklist(String zdhMachineworklistId);
    /**
	* 删除指定的业务集合
	**/
	public void deleteZdhMachineworklist(List dtos);
	
	/**
	 * 进行申请查询操作业务处理
	 */

	
	/**
	 * 进行申请查询操作业务处理(分页)
	 * 
	 * @return QueryListObj 封装了结果集及记录总数的对象
	 */
	 public QueryListObj listZdhMachineworklist();
	 public QueryListObj listZdhMachineworklistByHql(String hql);
	 public QueryListObj getZdhMachineworklistByHql(String hql,int beginPage, int pageSize,String sql);

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
	
	  

	//please add your business methods start
	// to do it
	//add your business method end
	
	
}
