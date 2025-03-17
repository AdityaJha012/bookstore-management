package com.bookstore.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.models.BookCategory;
import com.bookstore.repositories.CategoryRepository;
import com.bookstore.services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService
{
	@Autowired private CategoryRepository repository;

	@Override
	public List<BookCategory> getList() 
	{
		return repository.findAll();
	}

	@Override
	public void saveCategory(BookCategory bc) 
	{
		repository.save(bc);
	}

	@Override
	public void removeCategoryRecord(int cid) 
	{
		repository.deleteById(cid);
	}

	@Override
	public BookCategory getBookCategory(int cid) 
	{
		return repository.findById(cid).orElse(null);
	}

	@Override
	public void updateCategoryRecord(BookCategory bc) 
	{
		repository.save(bc);
	}
}
