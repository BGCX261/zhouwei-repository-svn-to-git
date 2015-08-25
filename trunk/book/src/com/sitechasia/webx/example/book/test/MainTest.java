package com.sitechasia.webx.example.book.test;

import java.util.GregorianCalendar;
import java.util.List;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sitechasia.webx.example.book.model.Book;
import com.sitechasia.webx.example.book.model.Category;
import com.sitechasia.webx.example.book.service.Service;

public class MainTest {

	public static void main(String[] args) {
		run();
	}

	public static void run() {

		ApplicationContext context = new ClassPathXmlApplicationContext(
				"com\\sitechasia\\webx\\example\\book\\test\\spring.xml");

		Service service = (Service) context.getBean("service");

		Category category = new Category();

		category.setCategoryId(1L);
		category.setCategoryName("art");

		service.storeCategory(category);

		Book book = new Book();

		book.setBookId(1000L);
		book.setBookName("painting");
		book.setCategory(category);

		service.storeBook(book);

		Book book2 = new Book();

		book2.setBookId(1001L);
		book2.setBookName("opera");
		book2.setCategory(category);

		service.storeBook(book2);

		System.out.println(service.findBooksByCategoryId(1L).size());
		
		service.findBooksByCategoryId(1L);
		
		service.findBooksByCategoryId(1L);

		Book myBook1 = service.findBookAll().get(0);

		System.out.println(myBook1.getCategory().getCategoryName());

		Book myBook2 = service.findBookById(myBook1.getBookId());

		System.out.println(myBook2.getCategory().getCategoryName());

		service.deleteCategory(1L);

		// service.deleteBook(1000L);

	}
}
