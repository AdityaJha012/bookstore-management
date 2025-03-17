package com.bookstore.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
@RequestMapping("bookstore/inventory/book")
public class BookController 
{
	@Autowired
	private BookService bservice;
	@Autowired
	private CategoryService cservice;
	@Autowired
	private PublisherService pservice;
	
	@RequestMapping("list")
	public String getBookList(int pn, Model model)
	{
		Page<Book> plist = bservice.getBookList(pn-1);
		int tp = plist.getTotalPages();
		model.addAttribute("tp",tp);
		model.addAttribute("pn",pn);
		List<Book> list = plist.toList();
		model.addAttribute("blist", list);
		return "book/book-list";
	}
	
	@RequestMapping("add")
	public String getAddView(Model model)
	{
		List<BookCategory> clist = cservice.getList();
		List<BookPublisher> plist = pservice.getList();
		model.addAttribute("clist", clist);
		model.addAttribute("plist", plist);
		return "book/add-book";
	}
	
	@RequestMapping("save")
	public String saveBookRecord(Book book)
	{
		bservice.saveBookRecord(book);
		return "redirect:list?pn=1";
	}
	
	@RequestMapping("remove")
	public String removeBookRecord(int bid)
	{
		bservice.removeBookRecord(bid);
		return "redirect:list?pn=1";
	}
	
	@RequestMapping("edit")
	public String getEditView(int bid, Model model)
	{
		List<BookCategory> clist = cservice.getList();
		List<BookPublisher> plist = pservice.getList();
		Book book = bservice.getRecord(bid);
		model.addAttribute("clist", clist);
		model.addAttribute("plist", plist);
		model.addAttribute("book", book);
		return "book/edit-book";
	}
	
	@RequestMapping("update")
	public String updateBookRecord(Book book)
	{
		bservice.updateBookRecord(book);
		return "redirect:list?pn=1";
	}
}
