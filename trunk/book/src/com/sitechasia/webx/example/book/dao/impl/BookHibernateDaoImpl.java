package com.sitechasia.webx.example.book.dao.impl;

import java.util.List;
import org.hibernate.Query;
import com.sitechasia.webx.core.dao.hibernate3.BaseHibernateDomainDao;
import com.sitechasia.webx.example.book.dao.BookDao;
import com.sitechasia.webx.example.book.model.Book;

public class BookHibernateDaoImpl extends BaseHibernateDomainDao<Book>
		implements BookDao {

	public void store(Book book) {
		this.save(book);
	}

	public void delete(Long bookId) {
		this.deleteById(bookId);
	}

	public Book findById(Long bookId) {
		return this.get(bookId);
	}

	public List<Book> findBooksByCategoryId(Long categoryId) {
		return listByField("category.categoryId", categoryId, 0, 0);
	}

	public List<Book> findAll() {
		Query query = this.getSession().createQuery("from Book");
		return query.list();
		// return query.setCacheable(true).list();
	}
}
