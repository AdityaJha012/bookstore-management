package com.book.store.service.impl;

import com.book.store.model.Book;
import com.book.store.model.BookCategory;
import com.book.store.model.BookPublisher;
import com.book.store.repository.BookCategoryRepository;
import com.book.store.repository.BookPublisherRepository;
import com.book.store.repository.BookRepository;
import com.book.store.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookCategoryRepository bookCategoryRepository;

    @Autowired
    private BookPublisherRepository bookPublisherRepository;

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Page<Book> getAllBooks(int pageNo) {
        Pageable pageable = PageRequest.of(pageNo, 5);

        return this.bookRepository.findAll(pageable);
    }

    @Override
    public void saveBook(Book book) {
        final BookCategory category = this.bookCategoryRepository.findById(book.getCategoryId()).orElse(null);
        final BookPublisher publisher = this.bookPublisherRepository.findById(book.getPublisherId()).orElse(null);

        book.setCategory(category);
        book.setPublisher(publisher);
        book.setValidFlag('Y');
        book.setCreatedBy("Admin");
        book.setCreatedAt(new Timestamp(System.currentTimeMillis()));

        this.bookRepository.save(book);
    }

    @Override
    public Book getBook(long id) {
        return this.bookRepository.findById(id).orElse(null);
    }

    @Override
    public void updateBook(Book book) {
        final BookCategory category = this.bookCategoryRepository.findById(book.getCategoryId()).orElse(null);
        final BookPublisher publisher = this.bookPublisherRepository.findById(book.getPublisherId()).orElse(null);

        book.setCategory(category);
        book.setPublisher(publisher);
        book.setUpdatedBy("Admin");
        book.setCreatedAt(new Timestamp(System.currentTimeMillis()));

        this.bookRepository.save(book);
    }

    @Override
    public void deleteBook(long id) {
        this.bookRepository.deleteById(id);
    }

    @Override
    public int getBooksCount() {
        return this.bookRepository.getBooksCount();
    }
}
