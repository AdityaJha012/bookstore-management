package com.book.store.controller;

import com.book.store.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @GetMapping({"/", "/logout"})
    private String redirectToLoginPage() {
        return "redirect:/bookstore/user/login";
    }

    @GetMapping("bookstore/user/login")
    private String getLoginPage(Model model) {
        model.addAttribute("user", new User());

        return "user/login";
    }

    @GetMapping("bookstore/user/register")
    private String getRegisterPage(Model model) {
        model.addAttribute("user", new User());

        return "user/register";
    }

    @GetMapping("bookstore/user/dashboard")
    private String getUserDashboard() {
        return "user/dashboard";
    }
}
