package com.book.store.controller;

import com.book.store.service.BookCategoryService;
import com.book.store.service.BookPublisherService;
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

    @Autowired
    private BookPublisherService bookPublisherService;

    @GetMapping("dashboard")
    public String getManagerDashboard(Model model) {
        int categoriesCount = this.bookCategoryService.getCategoriesCount();
        int publishersCount = this.bookPublisherService.getPublishersCount();

        model.addAttribute("categoriesCount", categoriesCount);
        model.addAttribute("publishersCount", publishersCount);

        return "home/dashboard";
    }
}
