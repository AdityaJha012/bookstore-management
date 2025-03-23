package com.book.store.controller;

import com.book.store.model.BookCategory;
import com.book.store.service.BookCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("bookstore/manager/category")
public class BookCategoryController {
    @Autowired
    private BookCategoryService bookCategoryService;

    @GetMapping("list")
    private String getAllBookCategories(Model model) {
        final List<BookCategory> categories = this.bookCategoryService.getAllBookCategories();
        model.addAttribute("categories", categories);

        return "category/category-list";
    }

    @GetMapping("add-category")
    private String getAddCategoryPage() {
        return "category/add-category";
    }

    @PostMapping("save-category")
    private String saveCategory(BookCategory bookCategory) {
        this.bookCategoryService.saveCategory(bookCategory);

        return "redirect:list";
    }

    @GetMapping("edit-category")
    private String getEditCategoryPage(long id, Model model) {
        BookCategory category = this.bookCategoryService.getCategory(id);
        model.addAttribute("category", category);

        return "category/edit-category";
    }

    @PostMapping("update-category")
    private String updateCategory(BookCategory bookCategory) {
        this.bookCategoryService.updateCategory(bookCategory);

        return "redirect:list";
    }

    @GetMapping("delete-category")
    private String deleteCategory(long id) {
        this.bookCategoryService.deleteCategory(id);

        return "redirect:list";
    }
}
