package com.book.store.service;

import com.book.store.dto.PurchaseResult;
import com.book.store.model.Book;
import org.springframework.data.domain.Page;

public interface BookService {
    Page<Book> getAllBooks(int pageNo);

    Book getBookById(long id);

    PurchaseResult processBookPurchase(Long userId, String userName, long bookId, int quantity);
}
