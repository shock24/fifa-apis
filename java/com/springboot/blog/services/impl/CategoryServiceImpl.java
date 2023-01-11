package com.springboot.blog.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.blog.entities.Category;
import com.springboot.blog.exceptions.ResourceNotFoundException;
import com.springboot.blog.payloads.CategoryDto;
import com.springboot.blog.repositories.CategoryRepo;
import com.springboot.blog.services.CategoryService;


@Service
public class CategoryServiceImpl implements CategoryService {

	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private CategoryRepo categoryRepo;
	
	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {
		Category cat = this.modelMapper.map(categoryDto, Category.class);
		Category addedCat = this.categoryRepo.save(cat);
		return this.modelMapper.map(addedCat, CategoryDto.class);
	}

	@Override
	public CategoryDto getCategoryById(Integer categoryId) {
		Category cat = this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category", "Category Id", categoryId));
		return this.modelMapper.map(cat, CategoryDto.class);
	}

	@Override
	public List<CategoryDto> getCategories() {
		List<CategoryDto> allCategories = this.categoryRepo.findAll().stream().map((category) -> this.modelMapper.map(category, CategoryDto.class)).collect(Collectors.toList());
		
		return allCategories;
	}

	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {
		Category cat = this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category", "Category Id", categoryId));
		
		cat.setCategoryTitle(categoryDto.getCategoryTitle());
		cat.setCategoryDescription(categoryDto.getCategoryDescription());
		Category updatedCat = this.categoryRepo.save(cat);
		return this.modelMapper.map(updatedCat, CategoryDto.class);
	}

	@Override
	public void deleteCategory(Integer categoryId) {
		Category cat = this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category", "Category Id", categoryId));
		this.categoryRepo.delete(cat);

	}

}
