package com.book.store.controller;

import com.book.store.model.BookCategory;
import com.book.store.service.BookCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("bookstore/manager")
public class HomeController {
    @Autowired
    private BookCategoryService bookCategoryService;

    @GetMapping("dashboard")
    public String getManagerDashboard(Model model) {
        int categoriesCount = this.bookCategoryService.getCategoriesCount();
        model.addAttribute("categoriesCount", categoriesCount);

        return "home/dashboard";
    }
}
