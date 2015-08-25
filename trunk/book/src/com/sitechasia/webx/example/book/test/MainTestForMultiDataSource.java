package com.sitechasia.webx.example.book.test;

import java.util.GregorianCalendar;
import java.util.List;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sitechasia.webx.example.book.model.Book;
import com.sitechasia.webx.example.book.model.Category;
import com.sitechasia.webx.example.book.service.Service;
import com.sitechasia.webx.example.book.service.ServiceForMultiDataSource;

public class MainTestForMultiDataSource {

	public static void main(String[] args) {
		run();
	}

	public static void run() {

		ApplicationContext context = new ClassPathXmlApplicationContext(
				"com\\sitechasia\\webx\\example\\book\\test\\spring_multi_datasource.xml");

		ServiceForMultiDataSource service = (ServiceForMultiDataSource) context
				.getBean("serviceForMultiDataSource");

		Category category = new Category();

		category.setCategoryId(1L);
		category.setCategoryName("art");
		category.setBooks(null);

		//
		service.storeCategory(category);

		Book book = new Book();

		book.setBookId(1000L);
		book.setBookName("painting");
		book.setCategory(category);

		//
		service.storeBook(book);

		service.deleteCategory(1L);

		// service.deleteBook(1000L);

	}
}
