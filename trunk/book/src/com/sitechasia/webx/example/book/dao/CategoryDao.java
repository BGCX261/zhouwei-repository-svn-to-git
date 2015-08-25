package com.sitechasia.webx.example.book.dao;

import java.util.List;
import com.sitechasia.webx.example.book.model.Category;

public interface CategoryDao {

	public void store(Category category);

	public void delete(Long categoryId);

	public Category findById(Long categoryId);

	public List<Category> findAll();
}
