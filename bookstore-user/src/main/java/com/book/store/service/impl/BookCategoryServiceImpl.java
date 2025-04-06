package com.book.store.service.impl;

import com.book.store.model.BookCategory;
import com.book.store.repository.BookCategoryRepository;
import com.book.store.service.BookCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookCategoryServiceImpl implements BookCategoryService {
    private final BookCategoryRepository bookCategoryRepository;

    @Override
    public BookCategory getBookCategoryDetails(long id) {
        return this.bookCategoryRepository.findById(id).orElse(null);
    }
}
