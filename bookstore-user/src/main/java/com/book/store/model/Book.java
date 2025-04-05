package com.book.store.model;

import jakarta.persistence.*;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "book_info")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Book extends Common {
    @Id
    @GeneratedValue(generator = "book_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "book_seq", sequenceName = "book_seq", allocationSize = 1)
    private Long id;
    private String title;
    private String description;
    private String[] authors;
    private int copies;
    private double price;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private BookCategory category;

    @ManyToOne
    @JoinColumn(name = "publisher_id", nullable = false)
    private BookPublisher publisher;
}
