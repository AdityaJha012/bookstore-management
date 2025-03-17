package com.bookstore.controllers;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.bookstore.models.User;
import com.bookstore.services.UserService;

@Controller
@RequestMapping("bookstore/user/profile")
public class UserProfileController 
{
	@Autowired UserService service;
	
	@RequestMapping("")
	public String getProfile(Model model, HttpSession ses)
	{
		User user = service.getUser((String)ses.getAttribute("userid"));
		model.addAttribute("user",user);
		ses.setAttribute("user", user);
		return "profile/user-details";
	}
	
	@RequestMapping("editprofile")
	public String getEditProfile(Model model, HttpSession ses)
	{
		User user = (User)ses.getAttribute("user");
		model.addAttribute("user",user);
		return "profile/edit-details";
	}
	
	@RequestMapping("updateprofile")
	public String updateProfile(User user, Model model, HttpSession ses)
	{
		service.updateUser(user);
		ses.setAttribute("name", user.getName());
		model.addAttribute("msg","Your profile has been updated!");
		return "profile/edit-details";
	}
	
	@RequestMapping("changepass")
	public String changePassword()
	{
		return "profile/change-password";
	}
	
	@RequestMapping("checkpass")
	public String checkPassword(String pass, HttpSession ses, Model model)
	{
		User user = (User)ses.getAttribute("user");
		if(!user.getPassword().equals(pass))
		{
			model.addAttribute("msg","Entered Password is incorrect!");
			return "profile/change-password";
		}
		ses.setAttribute("password", pass);
		return "profile/new-password";
	}
	
	@RequestMapping("updatepass")
	public String updatePassword(String pass, Model model, HttpSession ses)
	{
		if(pass.equals((String)ses.getAttribute("password")))
		{
			model.addAttribute("samep",1);
			model.addAttribute("msg","Your New Password is same as the Current Password!");
			return "profile/new-password";
		}
		model.addAttribute("samep",0);
		service.updatePassword(pass,(String)ses.getAttribute("userid"));
		User user = (User)ses.getAttribute("user");
		user.setPassword(pass);
		ses.setAttribute("password", pass);
		model.addAttribute("msg", "Password has been Changed!");
		return "profile/new-password";
	}	
}












