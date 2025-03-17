package com.bookstore.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.models.BookPublisher;
import com.bookstore.repositories.PublisherRepository;
import com.bookstore.services.PublisherService;

@Service
public class PublisherServiceImpl implements PublisherService
{
	@Autowired private PublisherRepository repository;

	@Override
	public List<BookPublisher> getList() 
	{
		return repository.findAll();
	}

	@Override
	public BookPublisher getRecord(int pid) 
	{
		return repository.findById(pid).orElse(null);
	}
}
