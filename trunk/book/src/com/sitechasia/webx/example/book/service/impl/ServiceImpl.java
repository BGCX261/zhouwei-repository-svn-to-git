package com.sitechasia.webx.example.book.service.impl;

import java.util.List;
import java.util.Set;

import org.springframework.transaction.annotation.Transactional;

import com.sitechasia.webx.core.cache.CacheToken;
import com.sitechasia.webx.core.cache.annotation.WebXCache;
import com.sitechasia.webx.example.book.dao.BookDao;
import com.sitechasia.webx.example.book.dao.CategoryDao;
import com.sitechasia.webx.example.book.model.Book;
import com.sitechasia.webx.example.book.model.Category;
import com.sitechasia.webx.example.book.service.Service;

public class ServiceImpl implements Service {

	private CategoryDao categoryDao;

	private BookDao bookDao;

	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}

	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}

	@Override
	@Transactional
	public void deleteBook(Long bookId) {
		bookDao.delete(bookId);
	}

	@Override
	@Transactional
	public void deleteCategory(Long categoryId) {
		categoryDao.delete(categoryId);
	}

	@Override
	public List<Book> findBookAll() {
		return bookDao.findAll();
	}

	@Override
	public Book findBookById(Long bookId) {
		return bookDao.findById(bookId);
	}

	@Override
	@WebXCache(classes = { Book.class, Category.class })
	public List<Book> findBooksByCategoryId(Long categoryId) {
		return bookDao.findBooksByCategoryId(categoryId);
	}

	@Override
	public List<Category> findCategoryAll() {
		return categoryDao.findAll();
	}

	@Override
	public Category findCategoryById(Long categoryId) {
		return categoryDao.findById(categoryId);
	}

	@Override
	@Transactional
	public void storeBook(Book book) {
		bookDao.store(book);
	}

	@Override
	@Transactional
	public void storeCategory(Category category) {
		categoryDao.store(category);
	}
}
