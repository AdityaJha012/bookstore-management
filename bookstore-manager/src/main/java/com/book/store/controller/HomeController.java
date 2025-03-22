package com.book.store.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("bookstore/manager")
public class HomeController {
    @GetMapping("dashboard")
    public String getManagerDashboard() {
        return "home/dashboard";
    }
}
