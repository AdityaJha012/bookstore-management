package com.book.store.service;

import com.book.store.model.BookAuthor;

import java.util.List;

public interface BookAuthorService {
    int getAuthorsCount();

    List<BookAuthor> getAllBookAuthors();

    void saveAuthor(BookAuthor bookAuthor);

    BookAuthor getAuthor(long id);

    void updateAuthor(BookAuthor bookAuthor);

    void deleteAuthor(long id);
}
