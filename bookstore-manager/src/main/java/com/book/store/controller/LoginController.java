package com.book.store.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
    @GetMapping({"/", "/logout"})
    private String redirectToLoginPage() {
        return "redirect:/bookstore/manager/login";
    }

    @GetMapping("bookstore/manager/login")
    private String getLoginPage() {
        return "home/login";
    }

    @PostMapping("bookstore/manager/authenticate")
    private String authenticateUser(String userName, String password, Model model) {
        if (userName.equals("admin") && password.equals("admin")) {
            model.addAttribute("message", "Logged in Successfully!");
            return "redirect:/bookstore/manager/dashboard";
        }

        model.addAttribute("message", "Invalid Credentials!");
        return "home/login";
    }
}
