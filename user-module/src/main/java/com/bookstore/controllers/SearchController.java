package com.bookstore.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.bookstore.models.Book;
import com.bookstore.models.BookCategory;
import com.bookstore.models.BookPublisher;
import com.bookstore.services.BookService;
import com.bookstore.services.CategoryService;
import com.bookstore.services.PublisherService;

@Controller
@RequestMapping("bookstore/user/searchbook")
public class SearchController 
{
	@Autowired private BookService bservice;
	@Autowired private CategoryService cservice;
	@Autowired private PublisherService pservice;
	
	@RequestMapping("")
	public String getSearchView(Model model)
	{
		List<BookCategory> clist = cservice.getList();
		List<BookPublisher> plist = pservice.getList();
		model.addAttribute("clist", clist);
		model.addAttribute("plist", plist);
		return "search/search-books";
	}
	
	@RequestMapping("byid")
	public String searchBookById(int bid, Model model)
	{
		List<Book> list = bservice.getListById(bid);
		model.addAttribute("blist",list);
		model.addAttribute("by", "By ID");
		return "search/search-book-list";
	}
	
	@RequestMapping("byauthor")
	public String searchBookByAuthor(String author, Model model)
	{
		List<Book> list = bservice.getListByAuthor(author);
		model.addAttribute("blist",list);
		model.addAttribute("by", "By Author");
		return "search/search-book-list";
	}
	
	@RequestMapping("bytitle")
	public String searchBookByTitle(String title, Model model)
	{
		List<Book> list = bservice.getListByTitle(title);
		model.addAttribute("blist",list);
		model.addAttribute("by", "By Title");
		return "search/search-book-list";
	}
	
	@RequestMapping("bycategory")
	public String searchBookByCategory(int catid, Model model)
	{
		List<Book> list = bservice.getListByCategory(catid);
		model.addAttribute("blist",list);
		model.addAttribute("by", "By Category");
		return "search/search-book-list";
	}
	
	@RequestMapping("bypublisher")
	public String searchBookByPublisher(int pubid, Model model)
	{
		List<Book> list = bservice.getListByPublisher(pubid);
		model.addAttribute("blist",list);
		model.addAttribute("by", "By Publisher");
		return "search/search-book-list";
	}
}
