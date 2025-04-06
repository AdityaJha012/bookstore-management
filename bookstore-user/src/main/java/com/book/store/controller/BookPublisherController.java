package com.book.store.controller;

import com.book.store.model.BookPublisher;
import com.book.store.service.BookPublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("bookstore/user/publisher")
public class BookPublisherController {
    @Autowired
    private BookPublisherService bookPublisherService;

    @RequestMapping(value = "/details", method = RequestMethod.GET)
    private String getBookPublisherDetails(@RequestParam long id, Model model) {
        final BookPublisher publisher = this.bookPublisherService.getPublisherDetails(id);

        if (publisher != null) {
            model.addAttribute("publisher", publisher);

            return "publisher/publisher-details";
        } else {
            return "redirect:bookstore/user/books/list";
        }
    }
}
