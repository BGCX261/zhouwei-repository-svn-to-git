package com.techstar.dmis.service.impl;

import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import org.apache.commons.lang.StringUtils;
import com.techstar.framework.dao.IBaseJdbcDao;

import com.techstar.framework.dao.model.QueryListObj;
import com.techstar.framework.utils.BeanHelper;
import com.techstar.framework.utils.SequenceCreator;
import com.techstar.dmis.dao.*;
import com.techstar.dmis.dto.DdCutofftitleDto;
import com.techstar.dmis.entity.DdCutofftitle;
import com.techstar.dmis.service.IDdCutofftitleService;
import com.techstar.dmis.service.workflow.IDdCutofftitleWFService;

import org.springframework.dao.DataAccessException;

//注册子表DAO
import com.techstar.dmis.dto.DdCutoffsequenceDto;
import com.techstar.dmis.entity.DdCutoffsequence;
import com.techstar.dmis.helper.dto.WorkflowHandleDto;

//please add your business methods start
// to do it
//add your business method end

/**
 * 业务对象服务接口实现类
 * 
 * @author
 * @date
 */
public class DdCutofftitleServiceImpl implements IDdCutofftitleService {
	// 注册DAO
	private IDdCutofftitleDao ddCutofftitleDao;

	private IBaseJdbcDao baseJdbcDao;
	
	private IDdCutofftitleWFService ddCutofftitleWFService;

	// 注册管理DAO
	private IDdCutoffsequenceDao ddCutoffsequenceDao;

	public void setDdCutoffsequenceDao(IDdCutoffsequenceDao ddCutoffsequenceDao) {
		this.ddCutoffsequenceDao = ddCutoffsequenceDao;
	}

	public DdCutofftitleServiceImpl() {
	}

	public void addDdCutofftitle(DdCutofftitleDto dto) {

		if (StringUtils.isEmpty(dto.getFid())) {
			if (StringUtils.isEmpty(dto.getFid())) {
				dto.setFid(new SequenceCreator().getUID());
			}
		}
		// 新增时候,主对象不用管子对象的保存
		DdCutofftitle ddCutofftitle = (DdCutofftitle) BeanHelper.buildBean(
				DdCutofftitle.class, dto);
		ddCutofftitleDao.saveOrUpdate(ddCutofftitle);
	}

	// 用于实现基本增加或修改操作

	public void saveOrUpdateDdCutofftitle(DdCutofftitleDto dto) {
		if (StringUtils.isEmpty(dto.getFid())) {
			if (StringUtils.isEmpty(dto.getFid())) {
				dto.setFid(new SequenceCreator().getUID());
			}
		}
		DdCutofftitle ddCutofftitle = (DdCutofftitle) BeanHelper.buildBean(
				DdCutofftitle.class, dto);
		ddCutofftitleDao.saveOrUpdate(ddCutofftitle);
	}

	// 用于实现基本删除操作
	public void deleteDdCutofftitle(String ddCutofftitleId) {
		DdCutofftitle ddCutofftitle = new DdCutofftitle();
		ddCutofftitle.setFid(ddCutofftitleId);
		ddCutofftitleDao.delete(ddCutofftitle);
	}

	// 用于实现基本删除集合操作
	public void deleteDdCutofftitle(List dtos) {
		List pos = new ArrayList();
		pos = (List) BeanHelper.buildBeans(DdCutofftitle.class, dtos);
		ddCutofftitleDao.deleteAll(pos);
	}

	// 用于实现基本DTOLOAD操作
	public DdCutofftitleDto loadDdCutofftitle(String fid) {
		DdCutofftitle ddCutofftitle = (DdCutofftitle) ddCutofftitleDao
				.findByPk(fid);
		DdCutofftitleDto dto = (DdCutofftitleDto) BeanHelper.buildBean(
				DdCutofftitleDto.class, ddCutofftitle);
		return dto;
	}

	// 用于实现列表操作
	public QueryListObj listDdCutofftitle() {
		QueryListObj obj = ddCutofftitleDao.getQueryList();
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(DdCutofftitleDto.class,
					obj.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}

	public QueryListObj listDdCutofftitleByHql(String hql) {
		QueryListObj obj = ddCutofftitleDao.getQueryListByHql(hql);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(DdCutofftitleDto.class,
					obj.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}

	public QueryListObj getDdCutofftitleByHql(String hql, int beginPage,
			int pageSize, String sql) {
		QueryListObj obj = ddCutofftitleDao.getQueryListByHql(hql, beginPage,
				pageSize);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(DdCutofftitleDto.class,
					obj.getElemList());
			obj.setElemList(dtos);
		}

		List sumList = ddCutofftitleDao.getObjPropertySums(sql);
		// System.out.println("sumList.size():"+sumList.size());
		obj.setPropertySum(sumList);
		return obj;
	}

	/**
	 * @business method list
	 * @excel 导入
	 * @序位表发布
	 */

	// please add your business methods start
	// to do it
	// add your business method end
	public IDdCutofftitleDao getDdCutofftitleDao() {
		return ddCutofftitleDao;
	}

	public void setDdCutofftitleDao(IDdCutofftitleDao ddCutofftitleDao) {
		this.ddCutofftitleDao = ddCutofftitleDao;
	}

	public void setBaseJdbcDao(IBaseJdbcDao baseJdbcDao) {
		this.baseJdbcDao = baseJdbcDao;
	}

	public void saveOrUpdateDdCutofftitle(List dtos) {
		List pos = new ArrayList();
		for (int i = 0; i < dtos.size(); i++) {
			DdCutofftitleDto ddCutofftitleDto = (DdCutofftitleDto) dtos.get(i);
			DdCutofftitle ddCutofftitle = (DdCutofftitle) BeanHelper.buildBean(
					DdCutofftitle.class, ddCutofftitleDto);
			pos.add(ddCutofftitle);
		}

		ddCutofftitleDao.saveOrUpdateAll(pos);
	}

	// 子表处理DAO

	public QueryListObj listDdCutoffsequence() {
		QueryListObj obj = ddCutoffsequenceDao.getQueryList();
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(DdCutoffsequenceDto.class,
					obj.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}

	public void saveOrUpdateDdCutoffsequence(DdCutoffsequenceDto dto) {

		if (StringUtils.isEmpty(dto.getFid())) {
			if (StringUtils.isEmpty(dto.getFid())) {
				dto.setFid(new SequenceCreator().getUID());
			}
		}
		DdCutoffsequence ddCutoffsequence = (DdCutoffsequence) BeanHelper
				.buildBean(DdCutoffsequence.class, dto);
		ddCutoffsequenceDao.saveOrUpdate(ddCutoffsequence);

	}

	public void deleteDdCutoffsequence(String fid) {

		DdCutoffsequence ddCutoffsequence = new DdCutoffsequence();
		ddCutoffsequence.setFid(fid);
		ddCutoffsequenceDao.delete(ddCutoffsequence);

	}

	public DdCutoffsequenceDto loadDdCutoffsequence(String fid) {
		DdCutoffsequence ddCutoffsequence = (DdCutoffsequence) ddCutoffsequenceDao
				.findByPk(fid);
		DdCutoffsequenceDto dto = (DdCutoffsequenceDto) BeanHelper.buildBean(
				DdCutoffsequenceDto.class, ddCutoffsequence);
		return dto;
	}

	public QueryListObj listDdCutoffsequenceByHql(String hql) {
		QueryListObj obj = ddCutoffsequenceDao.getQueryListByHql(hql);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(DdCutoffsequenceDto.class,
					obj.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}

	public void saveOrUpdateDdCutoffsequence(List dtos) {

		List pos = new ArrayList();
		for (int i = 0; i < dtos.size(); i++) {
			DdCutoffsequenceDto ddCutoffsequenceDto = (DdCutoffsequenceDto) dtos
					.get(i);
			DdCutoffsequence ddCutoffsequence = (DdCutoffsequence) BeanHelper
					.mapBean(DdCutoffsequence.class, ddCutoffsequenceDto);
			if (StringUtils.isEmpty(ddCutoffsequence.getFid())) {
				ddCutoffsequence.setFid(new SequenceCreator().getUID());
			}
			pos.add(ddCutoffsequence);
		}

		ddCutoffsequenceDao.saveOrUpdateAll(pos);

	}

	public void deleteDdCutoffsequence(List dtos) {
		List pos = new ArrayList();
		pos = (List) BeanHelper.buildBeans(DdCutoffsequence.class, dtos);
		ddCutoffsequenceDao.deleteAll(pos);
	}
	
	public void start(WorkflowHandleDto dto){
		ddCutofftitleWFService.start(dto);
	}
	//调度处长审批拉路序位表
	public void headerApprove(WorkflowHandleDto dto){
		ddCutofftitleWFService.limitLineSeqFormHeaderApprove(dto);
	}
	//拉路序位表发布
	public void release(WorkflowHandleDto dto) {
		ddCutofftitleWFService.limitLineSeqFormRelease(dto);
	}
	//拉路序位表修改
	public void modify(WorkflowHandleDto dto) {
		ddCutofftitleWFService.limitLineSeqFormModify(dto);
	}
	//负荷专工审核
	public void specApprove(WorkflowHandleDto dto){
		ddCutofftitleWFService.limitLineSeqFormSpecApprove(dto);
		
	}

	public void setDdCutofftitleWFService(
			IDdCutofftitleWFService ddCutofftitleWFService) {
		this.ddCutofftitleWFService = ddCutofftitleWFService;
	}
	
	

}
