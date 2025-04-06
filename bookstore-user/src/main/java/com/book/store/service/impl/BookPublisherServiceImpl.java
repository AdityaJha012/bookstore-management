package com.book.store.service.impl;

import com.book.store.model.BookPublisher;
import com.book.store.repository.BookPublisherRepository;
import com.book.store.service.BookPublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookPublisherServiceImpl implements BookPublisherService {
    @Autowired
    private BookPublisherRepository bookPublisherRepository;

    @Override
    public BookPublisher getPublisherDetails(long id) {
        return this.bookPublisherRepository.findById(id).orElse(null);
    }
}
