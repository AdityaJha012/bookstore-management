package com.book.store.service;

import com.book.store.model.BookCategory;

import java.util.List;

public interface BookCategoryService {
    List<BookCategory> getAllBookCategories();

    void saveCategory(BookCategory bookCategory);

    BookCategory getCategory(Long id);

    void updateCategory(BookCategory bookCategory);

    void deleteCategory(Long id);

    int getCategoriesCount();
}
