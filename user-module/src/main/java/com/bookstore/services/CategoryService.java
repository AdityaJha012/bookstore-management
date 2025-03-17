package com.bookstore.services;

import java.util.List;

import com.bookstore.models.BookCategory;

public interface CategoryService 
{
	List<BookCategory> getList();
	BookCategory getBookCategory(int cid);
}
