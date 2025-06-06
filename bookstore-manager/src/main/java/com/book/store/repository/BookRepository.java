package com.book.store.repository;

import com.book.store.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    @Query("SELECT COUNT(*) FROM Book b WHERE b.validFlag = 'Y'")
    int getBooksCount();
}
