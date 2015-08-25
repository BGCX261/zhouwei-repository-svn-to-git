package com.sitechasia.webx.example.book.service;

import com.sitechasia.webx.core.service.IService;
import com.sitechasia.webx.example.book.model.*;

public interface ServiceForMultiDataSource extends IService {

	public void storeCategory(Category category);

	public void deleteCategory(Long categoryId);

	public void storeBook(Book book);

	public void deleteBook(Long bookId);

}
