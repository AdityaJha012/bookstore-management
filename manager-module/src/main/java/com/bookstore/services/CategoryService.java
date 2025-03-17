package com.bookstore.services;

import java.util.List;

import com.bookstore.models.BookCategory;

public interface CategoryService 
{
	List<BookCategory> getList();
	void saveCategory(BookCategory bc);
	void removeCategoryRecord(int cid);
	BookCategory getBookCategory(int cid);
	void updateCategoryRecord(BookCategory bc);
}
