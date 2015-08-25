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
import com.techstar.dmis.dto.DdCutoffsequenceDto;
import com.techstar.dmis.entity.DdCutoffsequence;
import com.techstar.dmis.service.IDdCutoffsequenceService;
import org.springframework.dao.DataAccessException;

//please add your business methods start
// to do it
//add your business method end

/**
 * 业务对象服务接口实现类
 * 
 * @author
 * @date
 */
public class DdCutoffsequenceServiceImpl implements IDdCutoffsequenceService {
	// 注册DAO
	private IDdCutoffsequenceDao ddCutoffsequenceDao;

	private IBaseJdbcDao baseJdbcDao;

	// 注册管理DAO
	private IStdLineDao stdLineDao;

	public void setStdLineDao(IStdLineDao stdLineDao) {
		this.stdLineDao = stdLineDao;
	}

	public DdCutoffsequenceServiceImpl() {
	}

	public void deleteCutoffsequenceList(List list) {
		ddCutoffsequenceDao.deleteAll(list);
	}

	public void addDdCutoffsequence(DdCutoffsequenceDto dto) {

		if (StringUtils.isEmpty(dto.getFid())) {
			if (StringUtils.isEmpty(dto.getFid())) {
				dto.setFid(new SequenceCreator().getUID());
			}
		}
		// 新增时候,主对象不用管子对象的保存
		DdCutoffsequence ddCutoffsequence = (DdCutoffsequence) BeanHelper
				.buildBean(DdCutoffsequence.class, dto);
		ddCutoffsequenceDao.saveOrUpdate(ddCutoffsequence);
	}

	// 用于实现基本增加或修改操作

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

	// 用于实现基本删除操作
	public void deleteDdCutoffsequence(String ddCutoffsequenceId, String version) {
		DdCutoffsequence ddCutoffsequence = new DdCutoffsequence();
		ddCutoffsequence.setFid(ddCutoffsequenceId);
		ddCutoffsequence.setVersion(Integer.valueOf(version).intValue());
		ddCutoffsequenceDao.delete(ddCutoffsequence);
	}

	// 用于实现基本DTOLOAD操作
	public DdCutoffsequenceDto loadDdCutoffsequence(String fid) {
		DdCutoffsequence ddCutoffsequence = (DdCutoffsequence) ddCutoffsequenceDao
				.findByPk(fid);
		DdCutoffsequenceDto dto = (DdCutoffsequenceDto) BeanHelper.buildBean(
				DdCutoffsequenceDto.class, ddCutoffsequence);
		return dto;
	}

	// 用于实现列表操作
	public QueryListObj listDdCutoffsequence() {
		QueryListObj obj = ddCutoffsequenceDao.getQueryList();
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(DdCutoffsequenceDto.class,
					obj.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}

	public QueryListObj listDdCutoffsequenceByHql(String hql) {
		QueryListObj obj = ddCutoffsequenceDao.getQueryListByHql(hql);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.mapBeans(DdCutoffsequence.class, obj
					.getElemList());
			obj.setElemList(dtos);
		}
		return obj;
	}

	public QueryListObj getDdCutoffsequenceByHql(String hql, int beginPage,
			int pageSize, String sql) {
		QueryListObj obj = ddCutoffsequenceDao.getQueryListByHql(hql,
				beginPage, pageSize);
		if (obj.getElemList() != null) {
			List dtos = (List) BeanHelper.buildBeans(DdCutoffsequence.class,
					obj.getElemList());
			obj.setElemList(dtos);
		}

		List sumList = ddCutoffsequenceDao.getObjPropertySums(sql);
		// System.out.println("sumList.size():"+sumList.size());
		obj.setPropertySum(sumList);
		return obj;
	}

	/**
	 * @business method list
	 */

	// please add your business methods start
	// to do it
	// add your business method end
	public IDdCutoffsequenceDao getDdCutoffsequenceDao() {
		return ddCutoffsequenceDao;
	}

	public void setDdCutoffsequenceDao(IDdCutoffsequenceDao ddCutoffsequenceDao) {
		this.ddCutoffsequenceDao = ddCutoffsequenceDao;
	}

	public void setBaseJdbcDao(IBaseJdbcDao baseJdbcDao) {
		this.baseJdbcDao = baseJdbcDao;
	}

	public void saveOrUpdateDdCutoffsequence(List dtos) {
		List pos = new ArrayList();
		for (int i = 0; i < dtos.size(); i++) {
			DdCutoffsequenceDto ddCutoffsequenceDto = (DdCutoffsequenceDto) dtos
					.get(i);
			DdCutoffsequence ddCutoffsequence = (DdCutoffsequence) BeanHelper
					.buildBean(DdCutoffsequence.class, ddCutoffsequenceDto);
			pos.add(ddCutoffsequence);
		}

		ddCutoffsequenceDao.saveOrUpdateAll(pos);
	}

}
