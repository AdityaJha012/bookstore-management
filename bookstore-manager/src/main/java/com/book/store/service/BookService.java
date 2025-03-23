package com.book.store.service;

import com.book.store.model.Book;
import org.springframework.data.domain.Page;

public interface BookService {
    Page<Book> getAllBooks(int pageNo);

    void saveBook(Book book);

    Book getBook(long id);

    int getBooksCount();

    void updateBook(Book book);

    void deleteBook(long id);
}
