package com.techstar.dmis.service;

import java.util.List;
import java.util.Collection;
import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.dmis.dto.ZdhAutoondutylogDto;

	//注册子表DAO
    import com.techstar.dmis.dto.ZdhWorkbillDto;
	import com.techstar.dmis.dto.ZdhMachineworklistDto;
	import com.techstar.dmis.dto.ZdhRmrecDto;
	import com.techstar.dmis.dto.ZdhRsrecordDto;
	import com.techstar.dmis.dto.ZdhCharalterrecordDto;
	import com.techstar.dmis.dto.ZdhFaultlistDto;
	import com.techstar.dmis.dto.ZdhTransrecordDto;
import com.techstar.dmis.dto.ZdhOpexaminelistDto;
	

//please add your business methods start
	// to do it
//add your business method end
	
/** 
 * 业务对象服务接口类
 * @author 
 * @date
 */
public interface IZdhAutoondutylogService {

    public void addZdhAutoondutylog(ZdhAutoondutylogDto dto);

	/**
	 * 进行增加或修改操作业务处理
	 * 
	 * @param dto
	 *ZdhAutoondutylogDto 业务传输对象
	 * 
	 */
	public void saveOrUpdateZdhAutoondutylog(ZdhAutoondutylogDto dto);
	public void saveOrUpdateZdhAutoondutylog(List dtos);

	/**
	 * 进行加载的业务操作
	 * @param zdhAutoondutylogId
	 *            Integer 主键值ֵ
	 */
	public ZdhAutoondutylogDto loadZdhAutoondutylog(String zdhAutoondutylogId);

	/**
	 * 删除指定的业务
	 * @param zdhAutoondutylogId
	 *            Integer 主键值ֵ
	 */
	public void deleteZdhAutoondutylog(String zdhAutoondutylogId);
    /**
	* 删除指定的业务集合
	**/
	public void deleteZdhAutoondutylog(List dtos);
	
	/**
	 * 进行申请查询操作业务处理
	 */

	
	/**
	 * 进行申请查询操作业务处理(分页)
	 * 
	 * @return QueryListObj 封装了结果集及记录总数的对象
	 */
	 public QueryListObj listZdhAutoondutylog();
	 public QueryListObj listZdhAutoondutylogByHql(String hql);
	 public QueryListObj getZdhAutoondutylogByHql(String hql,int beginPage, int pageSize,String sql);

	//please add your business methods start
	// to do it
	//add your business method end

	
	

 	//子表处理DAO
       public QueryListObj listZdhWorkbill();
   public void saveOrUpdateZdhWorkbill(ZdhWorkbillDto dto);
   public void deleteZdhWorkbill(String workbillid);
   public ZdhWorkbillDto loadZdhWorkbill(String workbillid);
   public QueryListObj listZdhWorkbillByHql(String hql);
   public void saveOrUpdateZdhWorkbill(List dtos);
   public void deleteZdhWorkbill(List dtos);
	
	   public QueryListObj listZdhMachineworklist();
   public void saveOrUpdateZdhMachineworklist(ZdhMachineworklistDto dto);
   public void deleteZdhMachineworklist(String jobid);
   public ZdhMachineworklistDto loadZdhMachineworklist(String jobid);
   public QueryListObj listZdhMachineworklistByHql(String hql);
   public void saveOrUpdateZdhMachineworklist(List dtos);
   public void deleteZdhMachineworklist(List dtos);
	
	   public QueryListObj listZdhRmrec();
   public void saveOrUpdateZdhRmrec(ZdhRmrecDto dto);
   public void deleteZdhRmrec(String recordno);
   public ZdhRmrecDto loadZdhRmrec(String recordno);
   public QueryListObj listZdhRmrecByHql(String hql);
   public void saveOrUpdateZdhRmrec(List dtos);
   public void deleteZdhRmrec(List dtos);
	
	   public QueryListObj listZdhRsrecord();
   public void saveOrUpdateZdhRsrecord(ZdhRsrecordDto dto);
   public void deleteZdhRsrecord(String recordid);
   public ZdhRsrecordDto loadZdhRsrecord(String recordid);
   public QueryListObj listZdhRsrecordByHql(String hql);
   public void saveOrUpdateZdhRsrecord(List dtos);
   public void deleteZdhRsrecord(List dtos);
	
	   public QueryListObj listZdhCharalterrecord();
   public void saveOrUpdateZdhCharalterrecord(ZdhCharalterrecordDto dto);
   public void deleteZdhCharalterrecord(String recordsno);
   public ZdhCharalterrecordDto loadZdhCharalterrecord(String recordsno);
   public QueryListObj listZdhCharalterrecordByHql(String hql);
   public void saveOrUpdateZdhCharalterrecord(List dtos);
   public void deleteZdhCharalterrecord(List dtos);
	
	   public QueryListObj listZdhFaultlist();
   public void saveOrUpdateZdhFaultlist(ZdhFaultlistDto dto);
   public void deleteZdhFaultlist(String ffaultno);
   public ZdhFaultlistDto loadZdhFaultlist(String ffaultno);
   public QueryListObj listZdhFaultlistByHql(String hql);
   public void saveOrUpdateZdhFaultlist(List dtos);
   public void deleteZdhFaultlist(List dtos);
	
	   public QueryListObj listZdhTransrecord();
   public void saveOrUpdateZdhTransrecord(ZdhTransrecordDto dto);
   public void deleteZdhTransrecord(String transrecordid);
   public ZdhTransrecordDto loadZdhTransrecord(String transrecordid);
   public QueryListObj listZdhTransrecordByHql(String hql);
   public void saveOrUpdateZdhTransrecord(List dtos);
   public void deleteZdhTransrecord(List dtos);
	
	   public QueryListObj listZdhOpexaminelist();
   public void saveOrUpdateZdhOpexaminelist(ZdhOpexaminelistDto dto);
   public void deleteZdhOpexaminelist(String examinationid);
   public ZdhOpexaminelistDto loadZdhOpexaminelist(String examinationid);
   public QueryListObj listZdhOpexaminelistByHql(String hql);
   public void saveOrUpdateZdhOpexaminelist(List dtos);
   public void deleteZdhOpexaminelist(List dtos);
   public String carryOn(String ondutyno);
	
	  

	//please add your business methods start
	// to do it
	//add your business method end
	
	
}
