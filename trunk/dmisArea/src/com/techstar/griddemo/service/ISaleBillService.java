package com.techstar.griddemo.service;

import java.util.List;

import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.griddemo.dto.SaleBillDto;
import com.techstar.griddemo.dto.SaleDetailDto;
	
/** 
 * 业务对象服务接口类
 * @author 
 * @date
 */
public interface ISaleBillService {
	
	public void addSaleBill(SaleBillDto dto);
	public void addSaleDetail(SaleDetailDto dto);
	
	/**
	 * 修改操作业务处理
	 * @param dto
	 *SaleBillDto 业务传输对象
	 * 
	 */
	public void saveOrUpdateSaleBill(SaleBillDto dto);
	public void saveOrUpdateSaleDetail(SaleDetailDto dto);
	
	public void saveOrUpdateSaleBills(List dtos);
	public void saveOrUpdateSaleDetails(List dtos);

	/**
	 * 进行加载的业务操作
	 * 
	 * @param saleBillId
	 *            Integer 主键值ֵ
	 * 
	 */
	public SaleBillDto loadSaleBill(String saleBillId);
	public SaleDetailDto loadSaleDetail(String saleDetailId);

	/**
	 * 删除指定的业务
	 * 
	 * @param saleBillId
	 *            Integer 主键值ֵ
	 * 
	 */
	public void deleteSaleBill(String saleBillId);
	public void deleteSaleDetail(String saleDetailId);
    
	/**
	 * 进行申请查询操作业务处理
	 */

	public QueryListObj listSaleBill();
	public QueryListObj listSaleDetail();
	
	
	public QueryListObj listSaleBillByHql(String hql);
	public QueryListObj listSaleDetailByHql(String hql);
	
	/**
	 * 进行申请查询操作业务处理(分页)
	 * 
	 * @return QueryListObj 封装了结果集及记录总数的对象
	 */
	public QueryListObj getSaleBillByHql(String hql,int beginPage, int pageSize,String sql);
	public QueryListObj getSaleDetailByHql(String hql,int beginPage, int pageSize,String sql);
	//please add your business methods start
	// to do it
	//add your business method end
	
	
}
