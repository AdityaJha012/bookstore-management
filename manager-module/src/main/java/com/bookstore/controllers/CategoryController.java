package com.bookstore.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.bookstore.models.BookCategory;
import com.bookstore.services.CategoryService;

@Controller
@RequestMapping("bookstore/inventory/category")
public class CategoryController 
{
	@Autowired
	private CategoryService service;
	
	@RequestMapping("list")
	public String getCategoryList(Model model)
	{
		List<BookCategory> list = service.getList();
		model.addAttribute("catlist", list);
		return "category/category-list";
	}
	
	@RequestMapping("add")
	public String getAddView()
	{
		return "category/add-category";
	}
	
	@RequestMapping("save")
	public String saveCategoryRecord(BookCategory bc)
	{
		service.saveCategory(bc);
		return "redirect:list";
	}
	
	@RequestMapping("remove")
	public String removeCategoryRecord(int cid)
	{
		service.removeCategoryRecord(cid);
		return "redirect:list";
	}
	
	@RequestMapping("edit")
	public String editCategoryRecord(int cid, Model model)
	{
		BookCategory bc = service.getBookCategory(cid);
		model.addAttribute("cat",bc);
		return "category/edit-category";
	}
	
	@RequestMapping("update")
	public String updateCategoryRecord(BookCategory bc)
	{
		service.updateCategoryRecord(bc);
		return "redirect:list";
	}
	
	@RequestMapping("details")
	public String getCategoryDetails(int cid, Model model)
	{
		BookCategory bc = service.getBookCategory(cid);
		model.addAttribute("cat",bc);
		return "category/category-details";
	}
}
