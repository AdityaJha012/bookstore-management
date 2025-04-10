package com.book.store.service;

import com.book.store.dto.PurchaseResult;
import com.book.store.model.Book;
import com.book.store.model.UserTransaction;
import org.springframework.data.domain.Page;

public interface BookService {
    Page<Book> getAllBooks(int pageNo);

    Book getBookById(long id);

    PurchaseResult processBookPurchase(Long userId, String userName, long bookId, int quantity);

    Page<UserTransaction> getAllUserTransactions(Long userId, int pageNo);
}
