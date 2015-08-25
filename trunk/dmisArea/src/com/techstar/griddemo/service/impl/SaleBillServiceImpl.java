package com.techstar.griddemo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.framework.utils.BeanHelper;
import com.techstar.framework.utils.SequenceCreator;
import com.techstar.griddemo.dao.ISaleBillDao;
import com.techstar.griddemo.dao.ISaleDetailDao;
import com.techstar.griddemo.dto.SaleBillDto;
import com.techstar.griddemo.dto.SaleDetailDto;
import com.techstar.griddemo.entity.SaleBill;
import com.techstar.griddemo.entity.SaleDetail;
import com.techstar.griddemo.service.ISaleBillService;

/** 
 * 业务对象服务接口实现类
 * @author 
 * @date
 */
public class SaleBillServiceImpl implements ISaleBillService {
	//注册DAO
	private ISaleBillDao saleBillDao;
	public void setSaleBillDao(ISaleBillDao saleBillDao) {
		this.saleBillDao = saleBillDao;
	}   
    private ISaleDetailDao saleDetailDao;
	public void setSaleDetailDao(ISaleDetailDao saleDetailDao) {
		 this.saleDetailDao = saleDetailDao;
    }
	  	
	public SaleBillServiceImpl() {
	
	}
	
	//新增
    public void addSaleBill(SaleBillDto dto) {
    	if (StringUtils.isEmpty(dto.getId())){
		      if( StringUtils.isEmpty(dto.getId())){
		          dto.setId(new SequenceCreator().getUID());
		       }
		}
    	//新增时候,主对象不用管子对象的保存
		SaleBill saleBill = (SaleBill) BeanHelper.buildBean(SaleBill.class, dto);
		saleBillDao.saveOrUpdate(saleBill);		
	}
	public void addSaleDetail(SaleDetailDto dto) {
		if (StringUtils.isEmpty(dto.getId())){
		      if( StringUtils.isEmpty(dto.getId())){
		          dto.setId(new SequenceCreator().getUID());
		       }
		}
		SaleDetail saleDetail = (SaleDetail) BeanHelper.buildBean(SaleDetail.class, dto);
		//设置主对象信息
		SaleBill saleBill = new SaleBill();
		saleBill.setId(dto.getSaleBillDto().getId());
		saleDetail.setSalebill(saleBill);	
		
		saleDetailDao.saveOrUpdate(saleDetail);		
	}


	//修改操作
	public void saveOrUpdateSaleBill(SaleBillDto dto) {
		
		SaleBill saleBill = (SaleBill) BeanHelper.buildBean(SaleBill.class, dto);
		//对于存在子对象的主对象修改时,必须考虑子信息的保存
		//取得原主对象及其子对象
		SaleBill oldSaleBill = saleBillDao.findByPk(saleBill.getId());
		oldSaleBill.getSaledetails().size();
		
		saleBill.setSaledetails(oldSaleBill.getSaledetails());
		saleBillDao.merge(saleBill);
	}
	public void saveOrUpdateSaleDetail(SaleDetailDto dto) {
		SaleDetail saleDetail = (SaleDetail) BeanHelper.buildBean(SaleDetail.class, dto);
		//对于子对象修改时,需要考虑主对象
		//设置主对象信息
		SaleBill saleBill = new SaleBill();
		saleBill.setId(dto.getSaleBillDto().getId());
		saleDetail.setSalebill(saleBill);	
		
		saleDetailDao.saveOrUpdate(saleDetail);
	}	
    //用于实现基本删除操作
	public void deleteSaleBill(String saleBillId) {
		SaleBill saleBill = new SaleBill();
		saleBill.setId(saleBillId);
		saleBillDao.delete(saleBill);
	}
   //用于实现基本DTOLOAD操作
	public SaleBillDto loadSaleBill(String saleBillId) {
		SaleBill saleBill = (SaleBill) saleBillDao.findByPk(saleBillId);
		SaleBillDto dto = (SaleBillDto) BeanHelper.buildBean(SaleBillDto.class, saleBill);
		return dto;
	}
	//用于实现列表操作
    public QueryListObj listSaleBill() {
		QueryListObj obj = saleBillDao.getQueryList();
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(SaleBillDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}
    
	public void deleteSaleDetail(String saleDetailId) {
		SaleDetail  saleDetail = (SaleDetail) saleDetailDao.findByPk(saleDetailId);
		saleDetailDao.delete(saleDetail);
	}
 
	public QueryListObj getSaleBillByHql(String hql, int beginPage, int pageSize, String sql) {
		QueryListObj obj = saleBillDao.getQueryListByHql(hql, beginPage, pageSize);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(SaleBillDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		
		List sumList = saleBillDao.getObjPropertySums(sql);
		//System.out.println("sumList.size():"+sumList.size());
		obj.setPropertySum(sumList);
		return obj;
	}


	public QueryListObj getSaleDetailByHql(String hql, int beginPage, int pageSize, String sql) {
		QueryListObj obj = saleDetailDao.getQueryListByHql(hql, beginPage, pageSize);
		if (obj.getElemList() != null&&obj.getElemList().size()>0) {
			String biiid = ((SaleDetail)obj.getElemList().get(0)).getSalebill().getId();
			List dtos = (List) BeanHelper.buildBeans(SaleDetailDto.class, obj
					.getElemList());
			SaleBillDto billdto = new SaleBillDto();
			billdto.setId(biiid);
			ArrayList nlist = new ArrayList();
			for(int i=0;i<dtos.size();i++){
				SaleDetailDto dto = (SaleDetailDto)dtos.get(i);
				dto.setSaleBillDto(billdto);
				nlist.add(dto);
			}
			obj.setElemList(nlist);
		}
		
		List sumList = saleDetailDao.getObjPropertySums(sql);
		obj.setPropertySum(sumList);
		
		return obj;
	}


	public QueryListObj listSaleBillByHql(String hql) {
		QueryListObj obj = saleBillDao.getQueryListByHql(hql);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(SaleBillDto.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}


	public QueryListObj listSaleDetail() {
		QueryListObj obj = saleDetailDao.getQueryList();
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(SaleDetailDto.class, obj.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}


	public QueryListObj listSaleDetailByHql(String hql) {
		QueryListObj obj = saleDetailDao.getQueryListByHql(hql);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(SaleDetailDto.class, obj.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}


	public SaleDetailDto loadSaleDetail(String saleDetailId) {
		SaleDetail saleDetail = (SaleDetail) saleDetailDao.findByPk(saleDetailId);
		SaleBillDto saleBillDto = (SaleBillDto) BeanHelper.buildBean(SaleBillDto.class, saleDetail.getSalebill());
		
		SaleDetailDto dto = (SaleDetailDto) BeanHelper.buildBean(SaleDetailDto.class, saleDetail);
		dto.setSaleBillDto(saleBillDto);
		return dto;
	}


	public void saveOrUpdateSaleBills(List dtos) {
		List pos = new ArrayList();
		for(int i=0;i<dtos.size();i++){
			SaleBillDto saleBillDto = (SaleBillDto)dtos.get(i);
			
			SaleBill saleBill = (SaleBill) BeanHelper.buildBean(SaleBill.class, saleBillDto);
			//对于存在子对象的主对象修改时,必须考虑子信息的保存
			//取得原主对象及其子对象
			SaleBill oldSaleBill = saleBillDao.findByPk(saleBill.getId());
			oldSaleBill.getSaledetails().size();
			saleBill.setSaledetails(oldSaleBill.getSaledetails());
			
			pos.add(saleBill);
		}
		
		saleBillDao.saveOrUpdateAll(pos);	
	}



	public void saveOrUpdateSaleDetails(List dtos) {
		List pos = new ArrayList();
		for(int i=0;i<dtos.size();i++){
			SaleDetailDto saleDetailDto = (SaleDetailDto)dtos.get(i);
			if(saleDetailDto.getId()==null||saleDetailDto.getId().trim().equals("")){
				saleDetailDto.setId(new SequenceCreator().getUID());
			}
			SaleDetail saleDetail = (SaleDetail) BeanHelper.buildBean(SaleDetail.class, saleDetailDto);
			
			SaleBill saleBill = new SaleBill();
			saleBill.setId(saleDetailDto.getSaleBillDto().getId());
			saleDetail.setSalebill(saleBill);
			
			pos.add(saleDetail);
		}
		
		saleDetailDao.saveOrUpdateAll(pos);
	}


	
	
	 /**
    * @business method list
	  */
 
	//please add your business methods start
	// to do it
	//add your business method end

	
		


	
}
