package com.book.store.service.impl;

import com.book.store.model.Book;
import com.book.store.repository.BookRepository;
import com.book.store.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    @Override
    public Page<Book> getAllBooks(int pageNo) {
        Pageable pageable = PageRequest.of(pageNo, 5);

        return this.bookRepository.findAll(pageable);
    }
}
