package com.book.store.service.impl;

import com.book.store.model.BookPublisher;
import com.book.store.repository.BookPublisherRepository;
import com.book.store.service.BookPublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class BookPublisherServiceImpl implements BookPublisherService {
    @Autowired
    private BookPublisherRepository bookPublisherRepository;

    @Override
    public List<BookPublisher> getAllBookPublishers() {
        return this.bookPublisherRepository.findAll();
    }

    @Override
    public void savePublisher(BookPublisher bookPublisher) {
        bookPublisher.setValidFlag('Y');
        bookPublisher.setCreatedBy("Admin");
        bookPublisher.setCreatedAt(new Timestamp(System.currentTimeMillis()));

        this.bookPublisherRepository.save(bookPublisher);
    }

    @Override
    public BookPublisher getPublisher(long id) {
        return this.bookPublisherRepository.findById(id).orElse(null);
    }

    @Override
    public void updatePublisher(BookPublisher bookPublisher) {
        bookPublisher.setUpdatedBy("Admin");
        bookPublisher.setUpdatedAt(new Timestamp(System.currentTimeMillis()));

        this.bookPublisherRepository.save(bookPublisher);
    }

    @Override
    public void deletePublisher(long id) {
        this.bookPublisherRepository.deleteById(id);
    }

    @Override
    public int getPublishersCount() {
        return this.bookPublisherRepository.getPublishersCount();
    }
}
