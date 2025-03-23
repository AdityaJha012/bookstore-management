package com.book.store.controller;

import com.book.store.model.BookPublisher;
import com.book.store.service.BookPublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("bookstore/manager/publisher")
public class BookPublisherController {
    @Autowired
    private BookPublisherService bookPublisherService;

    @GetMapping("list")
    private String getAllBookPublishers(Model model) {
        final List<BookPublisher> publishers = this.bookPublisherService.getAllBookPublishers();
        model.addAttribute("publishers", publishers);

        return "publisher/publisher-list";
    }

    @GetMapping("add-publisher")
    private String getAddPublisherPage() {
        return "publisher/add-publisher";
    }

    @PostMapping("save-publisher")
    private String savePublisher(BookPublisher bookPublisher) {
        this.bookPublisherService.savePublisher(bookPublisher);

        return "redirect:list";
    }

    @GetMapping("edit-publisher")
    private String getEditPublisherPage(long id, Model model) {
        BookPublisher publisher = this.bookPublisherService.getPublisher(id);
        model.addAttribute("publisher", publisher);

        return "publisher/edit-publisher";
    }

    @PostMapping("update-publisher")
    private String updatePublisher(BookPublisher bookPublisher) {
        this.bookPublisherService.updatePublisher(bookPublisher);

        return "redirect:list";
    }

    @GetMapping("delete-publisher")
    private String deletePublisher(long id) {
        this.bookPublisherService.deletePublisher(id);

        return "redirect:list";
    }
}
