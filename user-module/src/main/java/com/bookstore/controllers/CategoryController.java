package com.bookstore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.bookstore.models.BookCategory;
import com.bookstore.services.CategoryService;

@Controller
@RequestMapping("bookstore/user/category")
public class CategoryController 
{
	@Autowired private CategoryService service;
	
	@RequestMapping("details")
	public String getCategoryDetails(int cid, Model model)
	{
		BookCategory bc = service.getBookCategory(cid);
		model.addAttribute("cat",bc);
		return "category/category-details";
	}
}
