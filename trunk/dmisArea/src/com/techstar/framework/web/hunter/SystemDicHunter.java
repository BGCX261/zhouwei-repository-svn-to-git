package com.techstar.framework.web.hunter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.dom4j.Document;

import com.techstar.framework.service.commonquery.ICommonQueryService;

/**
 * 数据字典Hunter类
 * 
 * @author caojian Dec 18, 2006
 * 
 */
public class SystemDicHunter {
	private ICommonQueryService commonQueryService;
	
	public SystemDicHunter() {
	}


	public String getName() {
		return "systemdic";
	}

	public List hunter(Map maps) throws Exception {
		String type = (String) maps.get("type");
		String fatherId = (String)maps.get("fatherId");
		String sql = "";

		if (StringUtils.isEmpty(type)) {
			return new ArrayList();
		} else {
			type = type.trim();
		}
		
		if (StringUtils.isNotEmpty(fatherId)) {
			fatherId = fatherId.trim();
			sql = "select systemdicid as code, name " + 
			      "from v_zd_systemdic " + 
			      "where typename = '" + type + "' and fatherid = '" + fatherId
					+ "'";
		} else {
			sql = "select systemdicid as code, name " + 
			      "from v_zd_systemdic " + 
			      "where typename= '" + type + "'";
		}
		List list = commonQueryService.getListBySql(sql);
		return commonQueryService.getListBySql(sql);
	}

	public void setCommonQueryService(ICommonQueryService commonQueryService) {
		this.commonQueryService = commonQueryService;
	}
		
		

}