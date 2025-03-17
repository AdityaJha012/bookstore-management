package com.bookstore.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.bookstore.models.Book;
import com.bookstore.services.BookService;

@Controller
@RequestMapping("bookstore/user/book")
public class BookController 
{
	@Autowired private BookService bservice;
	
	@RequestMapping("list")
	public String getBookList(int pn, Model model)
	{
		Page<Book> plist = bservice.getBookList(pn-1);
		int tp = plist.getTotalPages();
		model.addAttribute("tp",tp);
		model.addAttribute("pn",pn);
		List<Book> list = plist.toList();
		model.addAttribute("blist", list);
		return "purchase/book-list";
	}
	
}
