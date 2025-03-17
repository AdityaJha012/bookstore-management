package com.bookstore.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("bookstore/inventory/login")
public class LoginController 
{
	@RequestMapping("")
	private String getLoginView()
	{
		return "home/login";
	}
	
	@RequestMapping("authenticate")
	private String validateUser(String user, String pass, Model model)
	{
		if(user.equals("admin") && pass.equals("admin"))
		{
			return "redirect:/bookstore/inventory/home";
		}
		model.addAttribute("msg","User Authentication Failed!");
		return "home/login";
	}
}
