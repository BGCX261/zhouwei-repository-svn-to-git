package com.techstar.dmis.util;

import java.util.List;

import org.hibernate.Query;
import org.springframework.dao.DataAccessException;

import com.techstar.framework.dao.BaseHbnDaoImpl;

public class DataByHql extends BaseHbnDaoImpl {
    
	
	/**
	 * 获取交接班记录编号（自动化专业）
	 * @return
	 */
	public String getOndutyno(){
		String hql = "select a.ONDUTYNO from ZdhAutoondutylog a where a.SUCCESSIONTIME = (select max(b.SUCCESSIONTIME)  from ZdhAutoondutylog b)";
		String ondutyno = "";	
		List list = this.queryList(hql);
		System.out.println("list:"+list);
		Object ob = list.iterator().next();
		System.out.println("ob:"+ob);
		return null;
	}
}
