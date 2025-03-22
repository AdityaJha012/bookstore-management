package com.book.store.service.impl;

import com.book.store.model.BookCategory;
import com.book.store.repository.BookCategoryRepository;
import com.book.store.service.BookCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class BookCategoryServiceImpl implements BookCategoryService {
    @Autowired
    private BookCategoryRepository bookCategoryRepository;

    @Override
    public List<BookCategory> getAllBookCategories() {
        return this.bookCategoryRepository.findAll();
    }

    @Override
    public void saveCategory(BookCategory bookCategory) {
        bookCategory.setValidFlag('Y');
        bookCategory.setCreatedBy("Admin");
        bookCategory.setCreatedAt(new Timestamp(System.currentTimeMillis()));

        this.bookCategoryRepository.save(bookCategory);
    }

    @Override
    public BookCategory getCategory(Long id) {
        return this.bookCategoryRepository.findById(id).orElse(null);
    }

    @Override
    public void updateCategory(BookCategory bookCategory) {
        bookCategory.setUpdatedBy("Admin");
        bookCategory.setUpdatedAt(new Timestamp(System.currentTimeMillis()));

        this.bookCategoryRepository.save(bookCategory);
    }

    @Override
    public void deleteCategory(Long id) {
        this.bookCategoryRepository.deleteById(id);
    }

    @Override
    public int getCategoriesCount() {
        return this.bookCategoryRepository.getCategoriesCount();
    }
}
