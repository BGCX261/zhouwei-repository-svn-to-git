package com.sitechasia.webx.example.book.dao.impl;

import java.util.List;
import org.hibernate.Query;
import com.sitechasia.webx.core.dao.hibernate3.BaseHibernateDomainDao;
import com.sitechasia.webx.example.book.dao.CategoryDao;
import com.sitechasia.webx.example.book.model.Category;

public class CategoryHibernateDaoImpl extends BaseHibernateDomainDao<Category>
		implements CategoryDao {

	public void store(Category category) {
		this.save(category);
	}

	public void delete(Long categoryId) {
		this.deleteById(categoryId);
	}

	public Category findById(Long categoryId) {
		return this.get(categoryId);
	}

	public List<Category> findAll() {
		Query query = this.getSession().createQuery("from Category");
		return query.list();
		// return query.setCacheable(true).list();
	}
}
