package com.bookstore.services;

import java.util.List;

import com.bookstore.models.BookPublisher;

public interface PublisherService 
{
	List<BookPublisher> getList();
	void savePublisherRecord(BookPublisher bp);
	void removePublisherRecord(int pid);
	BookPublisher getRecord(int pid);
	void updatePublisherRecord(BookPublisher bp);
}
