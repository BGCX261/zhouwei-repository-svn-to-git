package com.techstar.dmis.service;

import java.util.List;
import java.util.Collection;
import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.dmis.dto.BhFixedvaluebillDto;

	//注册子表DAO
    import com.techstar.dmis.dto.BhFixedvaluebilldetailDto;
	

//please add your business methods start
	// to do it
//add your business method end
	
/** 
 * 业务对象服务接口类
 * @author 
 * @date
 */
public interface IBhFixedvaluebillService {

    public void addBhFixedvaluebill(BhFixedvaluebillDto dto);

	/**
	 * 进行增加或修改操作业务处理
	 * 
	 * @param dto
	 *BhFixedvaluebillDto 业务传输对象
	 * 
	 */
	public void saveOrUpdateBhFixedvaluebill(BhFixedvaluebillDto dto);
	public void saveOrUpdateBhFixedvaluebill(List dtos);

	/**
	 * 进行加载的业务操作
	 * @param bhFixedvaluebillId
	 *            Integer 主键值ֵ
	 */
	public BhFixedvaluebillDto loadBhFixedvaluebill(String bhFixedvaluebillId);

	/**
	 * 删除指定的业务
	 * @param bhFixedvaluebillId
	 *            Integer 主键值ֵ
	 */
	public void deleteBhFixedvaluebill(String bhFixedvaluebillId);
    /**
	* 删除指定的业务集合
	**/
	public void deleteBhFixedvaluebill(List dtos);
	
	/**
	 * 进行申请查询操作业务处理
	 */

	
	/**
	 * 进行申请查询操作业务处理(分页)
	 * 
	 * @return QueryListObj 封装了结果集及记录总数的对象
	 */
	 public QueryListObj listBhFixedvaluebill();
	 public QueryListObj listBhFixedvaluebillByHql(String hql);
	 public QueryListObj getBhFixedvaluebillByHql(String hql,int beginPage, int pageSize,String sql);

	//please add your business methods start
	// to do it
	//add your business method end

	
	

 	//子表处理DAO
       public QueryListObj listBhFixedvaluebilldetail();
   public void saveOrUpdateBhFixedvaluebilldetail(BhFixedvaluebilldetailDto dto);
   public void deleteBhFixedvaluebilldetail(String serialno);
   public BhFixedvaluebilldetailDto loadBhFixedvaluebilldetail(String serialno);
   public QueryListObj listBhFixedvaluebilldetailByHql(String hql);
   public void saveOrUpdateBhFixedvaluebilldetail(List dtos);
   public void deleteBhFixedvaluebilldetail(List dtos);
	
	  

	//please add your business methods start
	// to do it
	//add your business method end
	
	
}
