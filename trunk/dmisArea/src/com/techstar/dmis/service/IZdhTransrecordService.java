package com.techstar.dmis.service;

import java.util.List;
import java.util.Collection;
import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.dmis.dto.ZdhTransrecordDto;

	//注册子表DAO
    import com.techstar.dmis.dto.StdStationDto;
import com.techstar.dmis.dto.ZdhAutoondutylogDto;
	

//please add your business methods start
	// to do it
//add your business method end
	
/** 
 * 业务对象服务接口类
 * @author 
 * @date
 */
public interface IZdhTransrecordService {

    public void addZdhTransrecord(ZdhTransrecordDto dto);

	/**
	 * 进行增加或修改操作业务处理
	 * 
	 * @param dto
	 *ZdhTransrecordDto 业务传输对象
	 * 
	 */
	public void saveOrUpdateZdhTransrecord(ZdhTransrecordDto dto);
	public void saveOrUpdateZdhTransrecord(List dtos);

	/**
	 * 进行加载的业务操作
	 * @param zdhTransrecordId
	 *            Integer 主键值ֵ
	 */
	public ZdhTransrecordDto loadZdhTransrecord(String zdhTransrecordId);

	/**
	 * 删除指定的业务
	 * @param zdhTransrecordId
	 *            Integer 主键值ֵ
	 */
	public void deleteZdhTransrecord(String zdhTransrecordId);
    /**
	* 删除指定的业务集合
	**/
	public void deleteZdhTransrecord(List dtos);
	
	/**
	 * 进行申请查询操作业务处理
	 */

	
	/**
	 * 进行申请查询操作业务处理(分页)
	 * 
	 * @return QueryListObj 封装了结果集及记录总数的对象
	 */
	 public QueryListObj listZdhTransrecord();
	 public QueryListObj listZdhTransrecordByHql(String hql);
	 public QueryListObj getZdhTransrecordByHql(String hql,int beginPage, int pageSize,String sql);

	//please add your business methods start
	// to do it
	//add your business method end

	//得到班号
	public String getOndutyno(); 
	

 	//子表处理DAO
       public QueryListObj listStdStation();
   public void saveOrUpdateStdStation(StdStationDto dto);
   public void deleteStdStation(String id);
   public StdStationDto loadStdStation(String id);
   public QueryListObj listStdStationByHql(String hql);
   public void saveOrUpdateStdStation(List dtos);
   public void deleteStdStation(List dtos);
	
	   public QueryListObj listZdhAutoondutylog();
   public void saveOrUpdateZdhAutoondutylog(ZdhAutoondutylogDto dto);
   public void deleteZdhAutoondutylog(String ondutyno);
   public ZdhAutoondutylogDto loadZdhAutoondutylog(String ondutyno);
   public QueryListObj listZdhAutoondutylogByHql(String hql);
   public void saveOrUpdateZdhAutoondutylog(List dtos);
   public void deleteZdhAutoondutylog(List dtos);
   //该传动章
   public void changeStatus(String transrecordid);
	  

	//please add your business methods start
	// to do it
	//add your business method end
	
	
}
