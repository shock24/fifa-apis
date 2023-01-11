package com.springboot.blog.services;

import java.util.List;

import com.springboot.blog.payloads.CategoryDto;

public interface CategoryService {
	
	//create
	CategoryDto createCategory(CategoryDto categoryDto);
	
	//read single category
	CategoryDto getCategoryById(Integer categoryId);
	
	//read all categories
	List<CategoryDto> getCategories();
	
	//update
	CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId);
	
	//delete
	void deleteCategory(Integer categoryId);
}
