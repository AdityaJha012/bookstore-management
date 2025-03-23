package com.book.store.service;

import com.book.store.model.BookCategory;

import java.util.List;

public interface BookCategoryService {
    List<BookCategory> getAllBookCategories();

    void saveCategory(BookCategory bookCategory);

    BookCategory getCategory(long id);

    void updateCategory(BookCategory bookCategory);

    void deleteCategory(long id);

    int getCategoriesCount();
}
