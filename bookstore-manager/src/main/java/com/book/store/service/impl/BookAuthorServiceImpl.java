package com.book.store.service.impl;

import com.book.store.model.BookAuthor;
import com.book.store.repository.BookAuthorRepository;
import com.book.store.service.BookAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class BookAuthorServiceImpl implements BookAuthorService {
    @Autowired
    private BookAuthorRepository bookAuthorRepository;

    @Override
    public List<BookAuthor> getAllBookAuthors() {
        return this.bookAuthorRepository.findAll();
    }

    @Override
    public void saveAuthor(BookAuthor bookAuthor) {
        bookAuthor.setValidFlag('Y');
        bookAuthor.setCreatedBy("Admin");
        bookAuthor.setCreatedAt(new Timestamp(System.currentTimeMillis()));

        this.bookAuthorRepository.save(bookAuthor);
    }

    @Override
    public BookAuthor getAuthor(long id) {
        return this.bookAuthorRepository.findById(id).orElse(null);
    }

    @Override
    public void updateAuthor(BookAuthor bookAuthor) {
        bookAuthor.setUpdatedBy("Admin");
        bookAuthor.setUpdatedAt(new Timestamp(System.currentTimeMillis()));

        this.bookAuthorRepository.save(bookAuthor);
    }

    @Override
    public void deleteAuthor(long id) {
        this.bookAuthorRepository.deleteById(id);
    }

    @Override
    public int getAuthorsCount() {
        return this.bookAuthorRepository.getAuthorsCount();
    }
}
