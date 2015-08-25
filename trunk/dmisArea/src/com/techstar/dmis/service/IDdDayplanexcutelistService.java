package com.techstar.dmis.service;

import java.util.List;

import com.techstar.dmis.dto.DdDayplanexcutelistDto;
import com.techstar.framework.dao.model.QueryListObj;

public interface IDdDayplanexcutelistService {

	  public void addDdDayplanexcutelist(DdDayplanexcutelistDto dto);

		/**
		 * 进行增加或修改操作业务处理

		 * 
		 * @param dto
		 *DdDoutageplanDto 业务传输对象
		 * 
		 */
		public void saveOrUpdateDdDayplanexcutelist(DdDayplanexcutelistDto dto);
		public void saveOrUpdateDdDayplanexcutelist(List dtos);

		/**
		 * 进行加载的业务操作

		 * @param ddDoutageplanId
		 *            Integer 主键值ֵ

		 */
		public DdDayplanexcutelistDto loadDdDayplanexcutelist(String ddDayplanexcutelistId);

		/**
		 * 删除指定的业务

		 * @param ddDoutageplanId
		 *            Integer 主键值ֵ

		 */
		public void deleteDdDayplanexcutelist(String DdDayplanexcutelistId);
	    
		/**
		 * 进行申请查询操作业务处理
		 */

		
		/**
		 * 进行申请查询操作业务处理(分页)
		 * 
		 * @return QueryListObj 封装了结果集及记录总数的对象

		 */
	public QueryListObj listDdDayplanexcutelist();
	public QueryListObj listDdDayplanexcutelistByHql(String hql);
	public QueryListObj getDdDayplanexcutelistByHql(String hql,int beginPage, int pageSize,String sql);


		//please add your business methods start
		// to do it
		//add your business method end

		
		

		//please add your business methods start
		// to do it
		//add your business method end
		
		
	}
