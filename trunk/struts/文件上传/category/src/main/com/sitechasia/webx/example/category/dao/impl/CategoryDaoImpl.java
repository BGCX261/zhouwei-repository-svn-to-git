//dao.impl
//.java
package com.sitechasia.webx.example.category.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.util.Assert;
import com.sitechasia.webx.core.dao.hibernate3.BaseHibernateDomainDao;
import com.sitechasia.webx.core.support.Page;
import com.sitechasia.webx.example.category.dao.CategoryIDao;
import com.sitechasia.webx.example.category.model.CategoryDo;

public class CategoryDaoImpl extends BaseHibernateDomainDao<CategoryDo>
		implements CategoryIDao {
	/**
	 * 
	 */
	public Page searchCategorys(int pageNo, int pageSize, String sortStr,
			Object... params) {

		String hql = " from CategoryDo  where 1=1  ";
		if (params != null && params.length > 0) {
			// 拼查询条件
		}
		if (sortStr != null && sortStr.length() > 0) {
			hql += "order by " + sortStr;
		}
		return this.pagedQuery(hql, pageNo, pageSize, params);
	}
}
