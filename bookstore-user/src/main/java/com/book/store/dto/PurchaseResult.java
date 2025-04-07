package com.book.store.dto;

import com.book.store.model.Book;
import com.book.store.model.UserTransaction;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseResult {
    private Book book;
    private UserTransaction transaction;
}
