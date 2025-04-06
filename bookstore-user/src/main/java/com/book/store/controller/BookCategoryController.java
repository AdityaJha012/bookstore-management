package com.book.store.controller;

import com.book.store.model.BookCategory;
import com.book.store.service.BookCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@RequestMapping("bookstore/user/category")
public class BookCategoryController {
    private final BookCategoryService bookCategoryService;

    @GetMapping("details")
    private String getBookCategoryDetails(@RequestParam long id, Model model) {
        final BookCategory category = this.bookCategoryService.getBookCategoryDetails(id);

        if (category != null) {
            model.addAttribute("category", category);

            return "category/category-details";
        } else {
            return "redirect:bookstore/";
        }
    }
}
