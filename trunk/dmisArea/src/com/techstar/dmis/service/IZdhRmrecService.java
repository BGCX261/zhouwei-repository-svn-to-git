package com.techstar.dmis.service;


import java.util.List;
import java.util.Collection;
import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.dmis.dto.ZdhRmrecDto;

//please add your business methods start
	// to do it
//add your business method end
	
/** 
 * 业务对象服务接口类
 * @author 
 * @date
 */
public interface IZdhRmrecService {

    public void addZdhRmrec(ZdhRmrecDto dto);

	/**
	 * 进行增加或修改操作业务处理
	 * 
	 * @param dto
	 *ZdhRmrecDto 业务传输对象
	 * 
	 */
	public void saveOrUpdateZdhRmrec(ZdhRmrecDto dto);
	public void saveOrUpdateZdhRmrec(List dtos);

	/**
	 * 进行加载的业务操作
	 * @param zdhRmrecId
	 *            Integer 主键值ֵ
	 */
	public ZdhRmrecDto loadZdhRmrec(String zdhRmrecId);

	/**
	 * 删除指定的业务
	 * @param zdhRmrecId
	 *            Integer 主键值ֵ
	 */
	public void deleteZdhRmrec(String zdhRmrecId);
    
	/**
	 * 进行申请查询操作业务处理
	 */

	
	/**
	 * 进行申请查询操作业务处理(分页)
	 * 
	 * @return QueryListObj 封装了结果集及记录总数的对象
	 */
public QueryListObj listZdhRmrec();
public QueryListObj listZdhRmrecByHql(String hql);
public QueryListObj getZdhRmrecByHql(String hql,int beginPage, int pageSize,String sql);
public void deleteZdhRmrec(String zdhRmrecId,int version);
/**
 * 根椐ZdhRmrec对象外键系统图ID取数据集
 * @param foreignId
 * @return
 */
public ZdhRmrecDto getZdhRmrecByForeign(String foreignId);

	//please add your business methods start
	// to do it
	//add your business method end

	
	

	//please add your business methods start
	// to do it
	//add your business method end
	
	
}
