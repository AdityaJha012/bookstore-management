package com.book.store.controller;

import com.book.store.model.Book;
import com.book.store.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("bookstore/user/books")
public class BookController {
    private final BookService bookService;

    @GetMapping("list")
    private String getAllBooks(@RequestParam(defaultValue = "1") int pageNo, Model model) {
        Page<Book> pages = bookService.getAllBooks(pageNo - 1);
        int totalPages = pages.getTotalPages();
        List<Book> books = pages.toList();

        model.addAttribute("pageNo", pageNo);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("books", books);

        return "purchase/book-list";
    }
}
