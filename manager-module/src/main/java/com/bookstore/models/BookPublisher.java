package com.bookstore.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class BookPublisher 
{
	@Id
	@GeneratedValue(generator="pub_seq")
	@SequenceGenerator(name="pub_seq", initialValue = 11111, allocationSize = 1)
	private int pubid;
	private String publisher;
	private String email;
	private String address;
	private int phone;
	
	public int getPubid() 
	{
		return pubid;
	}
	public void setPubid(int pubid) 
	{
		this.pubid = pubid;
	}
	public String getPublisher() 
	{
		return publisher;
	}
	public void setPublisher(String publisher) 
	{
		this.publisher = publisher;
	}
	public String getEmail() 
	{
		return email;
	}
	public void setEmail(String email) 
	{
		this.email = email;
	}
	public String getAddress() 
	{
		return address;
	}
	public void setAddress(String address) 
	{		
		this.address = address;
	}
	public int getPhone() 
	{
		return phone;
	}
	public void setPhone(int phone) 
	{
		this.phone = phone;
	}
}
