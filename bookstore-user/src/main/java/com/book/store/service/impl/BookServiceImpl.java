package com.book.store.service.impl;

import com.book.store.dto.PurchaseResult;
import com.book.store.model.Book;
import com.book.store.model.BookAuthor;
import com.book.store.model.UserTransaction;
import com.book.store.repository.BookAuthorRepository;
import com.book.store.repository.BookRepository;
import com.book.store.repository.UserTransactionRepository;
import com.book.store.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final BookAuthorRepository bookAuthorRepository;
    private final UserTransactionRepository userTransactionRepository;

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

    @Override
    public Book getBookById(long id) {
        return this.bookRepository.findById(id).orElse(null);
    }

    @Override
    public PurchaseResult processBookPurchase(Long userId, String userName, long bookId, int quantity) {
        final Book book = this.getBookById(bookId);

        UserTransaction userTransaction = UserTransaction.builder()
                .orderId(UUID.randomUUID().toString())
                .bookId(bookId)
                .userId(userId)
                .quantity(quantity)
                .price(book.getPrice() * quantity)
                .build();

        userTransaction.setValidFlag('Y');
        userTransaction.setCreatedBy(userName);
        userTransaction.setCreatedAt(new Timestamp(System.currentTimeMillis()));

        this.userTransactionRepository.save(userTransaction);
        this.updateBookCopies(quantity, bookId);

        return new PurchaseResult(book, userTransaction);
    }

    @Override
    public Page<UserTransaction> getAllUserTransactions(Long userId, int pageNo) {
        Pageable pageable = PageRequest.of(pageNo, 5);

        return this.userTransactionRepository.findAllByUserId(userId, pageable);
    }

    private void updateBookCopies(int quantity, long bookId) {
        this.bookRepository.updateBookCopies(quantity, bookId);
    }
}
