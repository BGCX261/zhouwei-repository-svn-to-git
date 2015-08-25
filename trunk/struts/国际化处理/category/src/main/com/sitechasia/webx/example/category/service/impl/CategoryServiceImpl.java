package com.sitechasia.webx.example.category.service.impl;

import java.util.List;
import com.sitechasia.webx.core.service.impl.BaseDOVOService;
import com.sitechasia.webx.core.support.Page;
import com.sitechasia.webx.dozer.DozerConverter;
import com.sitechasia.webx.example.category.dao.CategoryIDao;
import com.sitechasia.webx.example.category.model.CategoryDo;
import com.sitechasia.webx.example.category.service.CategoryIService;
import com.sitechasia.webx.example.category.vo.CategoryVo;

/**
 * @author Administrator
 * 
 */

public class CategoryServiceImpl extends
		BaseDOVOService<CategoryDo, CategoryVo> implements CategoryIService {

	private CategoryIDao categoryIDao;
	private DozerConverter dozerConverter;

	public void setCategoryIDao(CategoryIDao categoryIDao) {
		this.categoryIDao = categoryIDao;
		this.setDao(categoryIDao);
	}

	public void setDozerConverter(DozerConverter dozerConverter) {
		this.dozerConverter = dozerConverter;
	}

	public Page searchCategorys(int pageNo, int pageSize, String sortStr,
			Object... params) {

		Page page = categoryIDao.searchCategorys(pageNo, pageSize, sortStr,
				params);
		List doList = page.getResult();
		// /List voList = getVOList(doList);
		List voList = dozerConverter.domainObjectsToViewObjects(doList,
				CategoryVo.class);
		page.setResult(voList);
		return page;
	}

}