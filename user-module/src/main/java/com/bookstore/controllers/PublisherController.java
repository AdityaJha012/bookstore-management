package com.bookstore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.bookstore.models.BookPublisher;
import com.bookstore.services.PublisherService;

@Controller
@RequestMapping("bookstore/user/publisher")
public class PublisherController 
{
	@Autowired
	private PublisherService service;
	
	@RequestMapping("details")
	public String getPublisherRecord(int pid, Model model)
	{
		BookPublisher bp = service.getRecord(pid);
		model.addAttribute("pub",bp);
		return "publisher/publisher-details";
	}
}
