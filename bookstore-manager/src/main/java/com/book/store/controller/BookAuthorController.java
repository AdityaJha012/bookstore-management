package com.book.store.controller;

import com.book.store.model.BookAuthor;
import com.book.store.service.BookAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("bookstore/manager/author")
public class BookAuthorController {
    @Autowired
    private BookAuthorService bookAuthorService;

    @GetMapping("list")
    private String getAllBookAuthors(Model model) {
        List<BookAuthor> authors = this.bookAuthorService.getAllBookAuthors();
        model.addAttribute("authors", authors);

        return "author/author-list";
    }

    @GetMapping("add-author")
    private String getAddAuthorPage() {
        return "author/add-author";
    }

    @PostMapping("save-author")
    private String saveAuthor(BookAuthor bookAuthor) {
        this.bookAuthorService.saveAuthor(bookAuthor);

        return "redirect:list";
    }

    @GetMapping("edit-author")
    private String getEditAuthorPage(long id, Model model) {
        BookAuthor author = this.bookAuthorService.getAuthor(id);
        model.addAttribute("author", author);

        return "author/edit-author";
    }

    @PostMapping("update-author")
    private String updateAuthor(BookAuthor bookAuthor) {
        this.bookAuthorService.updateAuthor(bookAuthor);

        return "redirect:list";
    }

    @GetMapping("delete-author")
    private String deleteAuthor(long id) {
        this.bookAuthorService.deleteAuthor(id);

        return "redirect:list";
    }
}
