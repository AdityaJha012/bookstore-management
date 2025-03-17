package com.bookstore.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.bookstore.models.Book;
import com.bookstore.repositories.BookRepository;
import com.bookstore.services.BookService;

@Service
public class BookServiceImpl implements BookService
{
	@Autowired private BookRepository repository;

	@Override
	public Page<Book> getBookList(int pn) 
	{
		Pageable page = PageRequest.of(pn, 3);
		return repository.findAll(page);
	}

	@Override
	public void saveBookRecord(Book book) 
	{
		repository.save(book);
	}

	@Override
	public void removeBookRecord(int bid) 
	{
		repository.deleteById(bid);
	}

	@Override
	public Book getRecord(int bid) 
	{
		return repository.findById(bid).orElse(null);
	}

	@Override
	public void updateBookRecord(Book book) 
	{
		repository.save(book);
	}

	@Override
	public List<Book> getListById(int bid) 
	{
		return repository.findByBid(bid);
	}

	@Override
	public List<Book> getListByAuthor(String author) 
	{		
		return repository.findByAuthor(author);
	}

	@Override
	public List<Book> getListByTitle(String title) 
	{
		return repository.findByTitle(title);
	}

	@Override
	public List<Book> getListByCategory(int catid) 
	{
		return repository.findByCatid(catid);
	}

	@Override
	public List<Book> getListByPublisher(int pubid) 
	{
		return repository.findByPubid(pubid);
	}
	
}
