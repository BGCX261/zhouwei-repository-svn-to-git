package com.sitechasia.webx.example.book.service.impl;

import org.springframework.transaction.annotation.Transactional;
import com.sitechasia.webx.example.book.dao.BookDao;
import com.sitechasia.webx.example.book.dao.CategoryDao;
import com.sitechasia.webx.example.book.model.Book;
import com.sitechasia.webx.example.book.model.Category;
import com.sitechasia.webx.example.book.service.ServiceForMultiDataSource;

public class ServiceImplForMultiDataSource implements ServiceForMultiDataSource {

	private CategoryDao categoryDao1;

	private BookDao bookDao1;

	private CategoryDao categoryDao2;

	private BookDao bookDao2;

	public void setCategoryDao1(CategoryDao categoryDao1) {
		this.categoryDao1 = categoryDao1;
	}

	public void setBookDao1(BookDao bookDao1) {
		this.bookDao1 = bookDao1;
	}

	public void setCategoryDao2(CategoryDao categoryDao2) {
		this.categoryDao2 = categoryDao2;
	}

	public void setBookDao2(BookDao bookDao2) {
		this.bookDao2 = bookDao2;
	}

	@Override
	@Transactional
	public void deleteBook(Long bookId) {
		bookDao1.delete(bookId);
		bookDao2.delete(bookId);
	}

	@Override
	@Transactional
	public void deleteCategory(Long categoryId) {
		categoryDao1.delete(categoryId);
		categoryDao2.delete(categoryId);
	}

	@Override
	@Transactional
	public void storeBook(Book book) {
		bookDao1.store(book);
		bookDao2.store(book);
	}

	@Override
	@Transactional
	public void storeCategory(Category category) {
		categoryDao1.store(category);
		categoryDao2.store(category);
	}
}
