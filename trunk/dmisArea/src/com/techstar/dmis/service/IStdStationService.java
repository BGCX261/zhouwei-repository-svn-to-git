package com.techstar.dmis.service;

import java.util.List;
import java.util.Collection;
import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.dmis.dto.StdStationDto;

	//注册子表DAO
    import com.techstar.dmis.dto.ZdhTransrecordDto;
	import com.techstar.dmis.dto.DdHpoweroperaterrdDto;
	import com.techstar.dmis.dto.DdWaterheightDto;
	import com.techstar.dmis.dto.BhAsregulateDto;
	import com.techstar.dmis.dto.DdPowerchangrecordDto;
	import com.techstar.dmis.dto.ZdhRmrecDto;
	

//please add your business methods start
	// to do it
//add your business method end
	
/** 
 * 业务对象服务接口类
 * @author 
 * @date
 */
public interface IStdStationService {

    public void addStdStation(StdStationDto dto);

	/**
	 * 进行增加或修改操作业务处理
	 * 
	 * @param dto
	 *StdStationDto 业务传输对象
	 * 
	 */
	public void saveOrUpdateStdStation(StdStationDto dto);
	public void saveOrUpdateStdStation(List dtos);

	/**
	 * 进行加载的业务操作
	 * @param stdStationId
	 *            Integer 主键值ֵ
	 */
	public StdStationDto loadStdStation(String stdStationId);

	/**
	 * 删除指定的业务
	 * @param stdStationId
	 *            Integer 主键值ֵ
	 */
	public void deleteStdStation(String stdStationId);
    /**
	* 删除指定的业务集合
	**/
	public void deleteStdStation(List dtos);
	
	/**
	 * 进行申请查询操作业务处理
	 */

	
	/**
	 * 进行申请查询操作业务处理(分页)
	 * 
	 * @return QueryListObj 封装了结果集及记录总数的对象
	 */
	 public QueryListObj listStdStation();
	 public QueryListObj listStdStationByHql(String hql);
	 public QueryListObj getStdStationByHql(String hql,int beginPage, int pageSize,String sql);

	//please add your business methods start
	// to do it
	//add your business method end

	
	
/*
 	//子表处理DAO
       public QueryListObj listZdhTransrecord();
   public void saveOrUpdateZdhTransrecord(ZdhTransrecordDto dto);
   public void deleteZdhTransrecord(String transrecordid);
   public ZdhTransrecordDto loadZdhTransrecord(String transrecordid);
   public QueryListObj listZdhTransrecordByHql(String hql);
   public void saveOrUpdateZdhTransrecord(List dtos);
   public void deleteZdhTransrecord(List dtos);
	
	   public QueryListObj listDdHpoweroperaterrd();
   public void saveOrUpdateDdHpoweroperaterrd(DdHpoweroperaterrdDto dto);
   public void deleteDdHpoweroperaterrd(String fid);
   public DdHpoweroperaterrdDto loadDdHpoweroperaterrd(String fid);
   public QueryListObj listDdHpoweroperaterrdByHql(String hql);
   public void saveOrUpdateDdHpoweroperaterrd(List dtos);
   public void deleteDdHpoweroperaterrd(List dtos);
	
	   public QueryListObj listDdWaterheight();
   public void saveOrUpdateDdWaterheight(DdWaterheightDto dto);
   public void deleteDdWaterheight(String fid);
   public DdWaterheightDto loadDdWaterheight(String fid);
   public QueryListObj listDdWaterheightByHql(String hql);
   public void saveOrUpdateDdWaterheight(List dtos);
   public void deleteDdWaterheight(List dtos);
	
	   public QueryListObj listBhAsregulate();
   public void saveOrUpdateBhAsregulate(BhAsregulateDto dto);
   public void deleteBhAsregulate(String asregulateid);
   public BhAsregulateDto loadBhAsregulate(String asregulateid);
   public QueryListObj listBhAsregulateByHql(String hql);
   public void saveOrUpdateBhAsregulate(List dtos);
   public void deleteBhAsregulate(List dtos);
	
	   public QueryListObj listDdPowerchangrecord();
   public void saveOrUpdateDdPowerchangrecord(DdPowerchangrecordDto dto);
   public void deleteDdPowerchangrecord(String fid);
   public DdPowerchangrecordDto loadDdPowerchangrecord(String fid);
   public QueryListObj listDdPowerchangrecordByHql(String hql);
   public void saveOrUpdateDdPowerchangrecord(List dtos);
   public void deleteDdPowerchangrecord(List dtos);
	
	   public QueryListObj listZdhRmrec();
   public void saveOrUpdateZdhRmrec(ZdhRmrecDto dto);
   public void deleteZdhRmrec(String recordno);
   public ZdhRmrecDto loadZdhRmrec(String recordno);
   public QueryListObj listZdhRmrecByHql(String hql);
   public void saveOrUpdateZdhRmrec(List dtos);
   public void deleteZdhRmrec(List dtos);
	
	  

	//please add your business methods start
	// to do it
	//add your business method end
	
	*/
}
