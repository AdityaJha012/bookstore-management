package com.book.store.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "book_category_info")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookCategory extends Common {
    @Id
    @GeneratedValue(generator = "book_category_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "book_category_seq", sequenceName = "book_category_seq", allocationSize = 1)
    private Long id;
    private String name;
    private String description;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Book> books = new ArrayList<>();
}
