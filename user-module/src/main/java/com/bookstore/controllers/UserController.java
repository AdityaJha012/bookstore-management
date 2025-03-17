package com.bookstore.controllers;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.bookstore.models.User;
import com.bookstore.services.UserService;

@Controller
@RequestMapping("bookstore/user")
public class UserController 
{
	@Autowired
	private UserService service;
	
	@RequestMapping("login")
	public String getLoginView()
	{
		return "user/login";
	}
	
	@RequestMapping("create-account")
	public String getRegistrationView(Model model)
	{
		model.addAttribute("user", new User());
		return "user/registration";
	}
	
	@RequestMapping("register")
	public String createUserAccount(User user, Model model)
	{
		String uid = user.getUserid();
		boolean userexist = service.isUserExist(uid);
		if(userexist)
		{
			model.addAttribute("user",user);
			model.addAttribute("msg", "User ID entered already Exists!");
			return "user/registration";
		}
		service.createAccount(user);
		model.addAttribute("name", user.getName());
		return "user/register-success";
	}
	
	@RequestMapping("authentication")
	public String authenticateUser(String uid, String pass, Model model, HttpSession ses)
	{
		User user = service.getUser(uid);
		if(user!=null)
		{
			String dpass = user.getPassword();
			if(pass.equals(dpass))
			{
				ses.setAttribute("name", user.getName());
				ses.setAttribute("userid", uid);
				return "redirect:home";
			}
			else
				model.addAttribute("msg", "Entered Password is Wrong!");
		}
		else
			model.addAttribute("msg", "Enter UserID does not Exist!");
		model.addAttribute("userid", uid);
		
		return "user/login";
	}
	
	@RequestMapping("logout")
	public String logoutUser(HttpSession ses, Model model)
	{
		model.addAttribute("name", ses.getAttribute("name"));
		ses.invalidate();
		return "user/logout-success";
	}
}






