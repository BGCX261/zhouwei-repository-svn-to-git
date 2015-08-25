package com.techstar.griddemo.web.facade;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.griddemo.dto.SaleBillDto;
import com.techstar.griddemo.dto.SaleDetailDto;
import com.techstar.griddemo.service.ISaleBillService;

public class SaleBillFacade {

	private ISaleBillService saleBillService;

	public void setSaleBillService(ISaleBillService saleBillService) {
		this.saleBillService = saleBillService;
	}
	
	public QueryListObj getSaleBillByHql(String hql, int beginPage, int pageSize, String sql){
		
		return this.saleBillService.getSaleBillByHql(hql, beginPage, pageSize, sql);
	}
	
	public QueryListObj getSaleDetailByHql(String hql, int beginPage, int pageSize, String sql){
		return this.saleBillService.getSaleDetailByHql(hql, beginPage, pageSize, sql);
	}
	
	public SaleBillDto getSaleBillById(String saleBillId){
		return this.saleBillService.loadSaleBill(saleBillId);
	}
	
	public SaleDetailDto getSaleDetailById(String saleDetailId){
		return this.saleBillService.loadSaleDetail(saleDetailId);
	}
	
	
	
	public void saveOrUpdateSaleBill(SaleBillDto dto){
		if(StringUtils.isEmpty(dto.getId())){
			this.saleBillService.addSaleBill(dto);
		}else{
			this.saleBillService.saveOrUpdateSaleBill(dto);
		}
	}
	
	public void saveOrUpdateSaleDetail(SaleDetailDto dto){
		this.saleBillService.saveOrUpdateSaleDetail(dto);
	}
	
	public QueryListObj listSaleBillByHql(String hql, int beginPage, int pageSize, String sql){
		return this.saleBillService.getSaleDetailByHql(hql, beginPage, pageSize, sql);
	}
	
	public SaleDetailDto loadSaleDetail(String saleDetailId){
		return this.saleBillService.loadSaleDetail(saleDetailId);
	}
	public void saveOrUpdateSaleDetails(List dtos){
		 this.saleBillService.saveOrUpdateSaleDetails(dtos);
	}
	
	public void deleteSaleDetails(String[] ids){
		for(int i=0;i<ids.length;i++){
			this.saleBillService.deleteSaleDetail(ids[i]);
		}
	}
}
