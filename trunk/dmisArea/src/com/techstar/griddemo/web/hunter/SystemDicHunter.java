package com.techstar.griddemo.web.hunter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.dom4j.Document;

import com.techstar.framework.service.commonquery.ICommonQueryService;
//please add your business methods start
// to do it
//add your business method end

 /** 
 * 此类为实现系统字典hunter类
 * @author 
 * @date
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
	//please add your business methods start
// to do it
//add your business method end
		

}