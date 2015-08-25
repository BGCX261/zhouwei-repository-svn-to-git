package com.sitechasia.webx.example.book.model;

import java.util.HashSet;
import java.util.Set;

import com.sitechasia.webx.core.model.IDomainObject;

public class Category implements IDomainObject {

	private Long categoryId;
	private String categoryName;
	private Set<Book> books = new HashSet<Book>();

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}

}
