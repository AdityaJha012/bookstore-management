package com.book.store.controller;

import com.book.store.model.Book;
import com.book.store.model.BookCategory;
import com.book.store.model.BookPublisher;
import com.book.store.service.BookCategoryService;
import com.book.store.service.BookPublisherService;
import com.book.store.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("bookstore/manager/book")
public class BookController {
    @Autowired
    private BookCategoryService bookCategoryService;

    @Autowired
    private BookPublisherService bookPublisherService;

    @Autowired
    private BookService bookService;

    @GetMapping("list")
    private String getAllBooks(int pageNo, Model model) {
        Page<Book> pages = bookService.getAllBooks(pageNo - 1);
        int totalPages = pages.getTotalPages();
        List<Book> books = pages.toList();

        model.addAttribute("pageNo", pageNo);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("books", books);

        return "book/book-list";
    }

    @GetMapping("add-book")
    private String getAddBookPage(Model model) {
        final List<BookCategory> categories = bookCategoryService.getAllBookCategories();
        final List<BookPublisher> publishers = bookPublisherService.getAllBookPublishers();

        model.addAttribute("categories", categories);
        model.addAttribute("publishers", publishers);

        return "book/add-book";
    }

    @PostMapping("save-book")
    private String saveBook(Book book) {
        this.bookService.saveBook(book);

        return "redirect:list?pageNo=1";
    }

    @GetMapping("edit-book")
    private String getEditBookPage(long id, Model model) {
        final List<BookCategory> categories = this.bookCategoryService.getAllBookCategories();
        final List<BookPublisher> publishers = this.bookPublisherService.getAllBookPublishers();
        final Book book = this.bookService.getBook(id);

        model.addAttribute("categories", categories);
        model.addAttribute("publishers", publishers);
        model.addAttribute("book", book);

        return "book/edit-book";
    }

    @PostMapping("update-book")
    private String updateBook(Book book) {
        this.bookService.updateBook(book);

        return "redirect:list?pageNo=1";
    }

    @PostMapping("delete-book")
    private String deleteBook(long id) {
        this.bookService.deleteBook(id);

        return "redirect:list?pageNo=1";
    }
}
