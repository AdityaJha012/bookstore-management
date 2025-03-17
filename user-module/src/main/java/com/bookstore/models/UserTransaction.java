package com.bookstore.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserTransaction 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int tid;
	private String userid;
	private int bid;
	private int quantity;
	private int price;
	private String date;
	
	public int getTid() 
	{
		return tid;
	}
	public void setTid(int tid) 
	{
		this.tid = tid;
	}
	public String getUserid() 
	{
		return userid;
	}
	public void setUserid(String userid) 
	{
		this.userid = userid;
	}
	public int getBid() 
	{
		return bid;
	}
	public void setBid(int bid) 
	{
		this.bid = bid;
	}
	public int getQuantity() 
	{
		return quantity;
	}
	public void setQuantity(int quantity) 
	{
		this.quantity = quantity;
	}
	public int getPrice() 
	{
		return price;
	}
	public void setPrice(int price) 
	{
		this.price = price;
	}
	public String getDate() 
	{
		return date;
	}
	public void setDate(String date) 
	{
		this.date = date;
	}	
	
}
