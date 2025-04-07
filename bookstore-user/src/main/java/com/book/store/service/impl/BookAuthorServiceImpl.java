package com.book.store.service.impl;

import com.book.store.model.BookAuthor;
import com.book.store.repository.BookAuthorRepository;
import com.book.store.service.BookAuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
@RequiredArgsConstructor
public class BookAuthorServiceImpl implements BookAuthorService {
    private final BookAuthorRepository bookAuthorRepository;

    @Override
    public String[] getAuthorNames(String[] authors) {
        return Arrays.stream(authors)
                .map(id -> {
                    return this.bookAuthorRepository.findById(Long.parseLong(id))
                            .map(BookAuthor::getName)
                            .orElse("Unknown");
                })
                .toArray(String[]::new);
    }
}
