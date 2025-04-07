package com.book.store.controller;

import com.book.store.dto.PurchaseResult;
import com.book.store.model.Book;
import com.book.store.service.BookAuthorService;
import com.book.store.service.BookService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("bookstore/user/")
public class PurchaseController {
    @Autowired
    private BookService bookService;

    @Autowired
    private BookAuthorService bookAuthorService;

    @GetMapping("purchase-page")
    private String showBookPurchasePage(@RequestParam long id, Model model) {
        final Book book = bookService.getBookById(id);

        if (book == null) {
            return "redirect:/bookstore/user/books/list";
        }

        String[] authors = this.bookAuthorService.getAuthorNames(book.getAuthors());

        book.setAuthors(authors);
        model.addAttribute("book", book);
        return "purchase/book-purchase";
    }

    @PostMapping("purchase-book")
    private String purchaseBook(
        @RequestParam int quantity,
        @RequestParam("id") long bookId,
        HttpSession session,
        Model model
    ) {
        Long userId = (Long) session.getAttribute("userId");
        String userName = (String) session.getAttribute("userName");

        if (userId == null || userName == null) {
            return "redirect:/bookstore/user/login";
        }
        try {
            PurchaseResult purchaseResult = this.bookService.processBookPurchase(userId, userName, bookId, quantity);

            model.addAttribute("transaction", purchaseResult.getTransaction());
            model.addAttribute("book", purchaseResult.getBook());
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/bookstore/user/purchase-page?id=" + bookId;
        }

        return "purchase/purchase-success";
    }
}
