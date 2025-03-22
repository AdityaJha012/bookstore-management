package com.book.store.service;

import com.book.store.model.BookPublisher;

import java.util.List;

public interface BookPublisherService {
    List<BookPublisher> getAllBookPublishers();

    void savePublisher(BookPublisher bookPublisher);

    BookPublisher getPublisher(Long id);

    void updatePublisher(BookPublisher bookPublisher);

    void deletePublisher(Long id);

    int getPublishersCount();
}
