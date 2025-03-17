package com.bookstore.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bookstore.models.Book;

public interface BookRepository extends JpaRepository<Book, Integer>
{
	List<Book> findByBid(int bid);
	List<Book> findByAuthor(String author);
	List<Book> findByTitle(String title);
	List<Book> findByCatid(int catid);
	List<Book> findByPubid(int pubid);
}
