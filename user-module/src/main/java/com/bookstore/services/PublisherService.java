package com.bookstore.services;

import java.util.List;

import com.bookstore.models.BookPublisher;

public interface PublisherService 
{
	List<BookPublisher> getList();
	BookPublisher getRecord(int pid);
}
