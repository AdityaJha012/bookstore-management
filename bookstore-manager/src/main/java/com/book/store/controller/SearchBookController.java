package com.book.store.controller;

import com.book.store.model.BookAuthor;
import com.book.store.model.BookCategory;
import com.book.store.model.BookPublisher;
import com.book.store.service.BookAuthorService;
import com.book.store.service.BookCategoryService;
import com.book.store.service.BookPublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("bookstore/manager/search-book")
public class SearchBookController {
    @Autowired
    private BookCategoryService bookCategoryService;

    @Autowired
    private BookPublisherService bookPublisherService;

    @Autowired
    private BookAuthorService bookAuthorService;

    @GetMapping("")
    private String getSearchPage(Model model) {
        final List<BookCategory> categories = this.bookCategoryService.getAllBookCategories();
        final List<BookPublisher> publishers = this.bookPublisherService.getAllBookPublishers();
        final List<BookAuthor> authors = this.bookAuthorService.getAllBookAuthors();

        model.addAttribute("categories", categories);
        model.addAttribute("publishers", publishers);
        model.addAttribute("authors", authors);

        return "search/search-book";
    }
}
