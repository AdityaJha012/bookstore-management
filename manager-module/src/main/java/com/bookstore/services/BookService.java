package com.bookstore.services;

import java.util.List;

import org.springframework.data.domain.Page;
import com.bookstore.models.Book;

public interface BookService 
{
	Page<Book> getBookList(int pn);
	void saveBookRecord(Book book);
	void removeBookRecord(int bid);
	Book getRecord(int bid);
	void updateBookRecord(Book book);
	List<Book> getListById(int bid);
	List<Book> getListByAuthor(String author);
	List<Book> getListByTitle(String title);
	List<Book> getListByCategory(int catid);
	List<Book> getListByPublisher(int pubid);
}
