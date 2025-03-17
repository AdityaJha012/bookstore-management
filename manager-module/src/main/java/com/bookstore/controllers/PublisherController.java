package com.bookstore.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.bookstore.models.BookPublisher;
import com.bookstore.services.PublisherService;

@Controller
@RequestMapping("bookstore/inventory/publisher")
public class PublisherController 
{
	@Autowired
	private PublisherService service;
	
	@RequestMapping("list")
	public String getPublisherList(Model model)
	{
		List<BookPublisher> list = service.getList();
		model.addAttribute("plist", list);
		return "publisher/publisher-list";
	}
	
	@RequestMapping("add")
	public String getAddView()
	{
		return "publisher/add-publisher";
	}
	
	@RequestMapping("save")
	public String savePublisherRecord(BookPublisher bp)
	{
		service.savePublisherRecord(bp);
		return "redirect:list";
	}
	
	@RequestMapping("remove")
	public String removePublisherRecord(int pid)
	{
		service.removePublisherRecord(pid);
		return "redirect:list";
	}
	
	@RequestMapping("edit")
	public String getEditView(int pid, Model model)
	{
		BookPublisher bp = service.getRecord(pid);
		model.addAttribute("pub", bp);
		return "publisher/edit-publisher";
	}
	
	@RequestMapping("update")
	public String updatePublisherRecord(BookPublisher bp)
	{
		service.updatePublisherRecord(bp);
		return "redirect:list";
	}
	
	@RequestMapping("details")
	public String getPublisherRecord(int pid, Model model)
	{
		BookPublisher bp = service.getRecord(pid);
		model.addAttribute("pub",bp);
		return "publisher/publisher-details";
	}
}
