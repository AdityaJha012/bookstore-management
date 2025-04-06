package com.book.store.service.impl;

import com.book.store.model.Book;
import com.book.store.model.BookAuthor;
import com.book.store.repository.BookAuthorRepository;
import com.book.store.repository.BookRepository;
import com.book.store.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final BookAuthorRepository bookAuthorRepository;

    @Override
    public Page<Book> getAllBooks(int pageNo) {
        Pageable pageable = PageRequest.of(pageNo, 5);
        Page<Book> bookPage = this.bookRepository.findAll(pageable);

        // Map author IDs to names for each book
        bookPage.forEach(book -> {
            String[] authorIds = book.getAuthors();

            if (authorIds != null) {
                String[] authorNames = Arrays.stream(authorIds)
                        .map(id -> bookAuthorRepository.findById(Long.parseLong(id)).map(BookAuthor::getName).orElse("Unknown"))
                        .toArray(String[]::new);
                book.setAuthors(authorNames);
            }
        });

        return bookPage;
    }
}
