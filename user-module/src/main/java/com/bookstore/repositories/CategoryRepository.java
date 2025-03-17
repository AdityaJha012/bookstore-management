package com.bookstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bookstore.models.BookCategory;

public interface CategoryRepository extends JpaRepository<BookCategory, Integer>
{
}
