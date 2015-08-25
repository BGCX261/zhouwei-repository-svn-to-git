package com.sitechasia.webx.example.book.service;

import java.util.List;
import java.util.Set;

import com.sitechasia.webx.core.service.IService;
import com.sitechasia.webx.example.book.model.*;

public interface Service extends IService {

	public void storeCategory(Category category);

	public void deleteCategory(Long categoryId);

	public Category findCategoryById(Long categoryId);

	public List<Category> findCategoryAll();

	public List<Book> findBooksByCategoryId(Long categoryId);

	public void storeBook(Book book);

	public void deleteBook(Long bookId);

	public Book findBookById(Long bookId);

	public List<Book> findBookAll();
}
