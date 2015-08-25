package com.techstar.griddemo.service;


import com.techstar.framework.dao.model.QueryListObj;
//please add your business methods start
	// to do it
//add your business method end

/** 
 * 字典服务接口类
 * @author 
 * @date
 */
public interface IDictionaryService {
	/**
	 * 删除实体
	 * */
	public boolean deleteById(String poName ,Object id);
	
	/**
	 * 根据实体类型及实体主键得到实体对象
	 * */
	public Object findById(String poName, Object id);
	
	/**
	 * 新增或修改实体
	 * */
	public Object saveOrUpdate(String poName, Object dtoObj);
	
	/**
	 * 得到指定字典表的list对象
	 * */
	public QueryListObj getQueryList(String poName);
	
	/**
	 * 得到指定字典表的list对象(分页)
	 * */
	public QueryListObj getQueryList(String poName, int beginPage, int pageSize);
	//please add your business methods start
	// to do it
//add your business method end
}
