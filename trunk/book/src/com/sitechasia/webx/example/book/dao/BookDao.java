package com.sitechasia.webx.example.book.dao;

import java.util.List;
import com.sitechasia.webx.example.book.model.Book;

public interface BookDao {

	public void store(Book book);

	public void delete(Long bookId);

	public Book findById(Long bookId);

	public List<Book> findBooksByCategoryId(Long categoryId);

	public List<Book> findAll();
}
