package com.bookstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bookstore.models.BookPublisher;

public interface PublisherRepository extends JpaRepository<BookPublisher, Integer>
{
}
