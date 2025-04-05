package com.book.store.model;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "book_transaction_info")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserTransaction extends Common {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_transaction_seq")
    @SequenceGenerator(name = "user_transaction_seq", sequenceName = "user_transaction_seq", allocationSize = 1)
    private Long id;

    private String userName;
    private long bid;
    private int quantity;
    private int price;
    private Timestamp transactionDate;
}
