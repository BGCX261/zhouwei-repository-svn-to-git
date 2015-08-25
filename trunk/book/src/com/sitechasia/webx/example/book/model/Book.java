package com.sitechasia.webx.example.book.model;

import com.sitechasia.webx.core.model.IDomainObject;

public class Book implements IDomainObject {

	private Long bookId;
	private String bookName;
	private Category category;

	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}
