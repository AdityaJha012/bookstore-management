package com.bookstore.controllers;

import java.time.LocalDate;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.bookstore.models.Book;
import com.bookstore.models.UserTransaction;
import com.bookstore.services.BookService;
import com.bookstore.services.TransactionService;

@Controller
@RequestMapping("bookstore/user/purchase")
public class PurchaseController 
{
	@Autowired private BookService bservice;
	@Autowired private TransactionService tservice;
	private Book book;
	
	@RequestMapping("")
	public String getPurchaseView(Model model, int bid)
	{
		book = bservice.getRecord(bid);
		model.addAttribute("book",book);
		return "purchase/purchase-now";
	}
	
	@RequestMapping("do")
	public String doPurchase(Model model, int quantity, HttpSession ses)
	{
		UserTransaction transaction = new UserTransaction();
		transaction.setUserid((String)ses.getAttribute("userid"));
		transaction.setBid(book.getBid());
		transaction.setQuantity(quantity);
		transaction.setPrice(book.getPrice());
		transaction.setDate(LocalDate.now().toString());
		tservice.saveTransaction(transaction);
		bservice.updateBookQuantity(quantity, book.getBid());
		return "purchase/buy";
	}
	
	@RequestMapping("view-transaction")
	public String getTransactionList(Model model, HttpSession ses)
	{
		List<UserTransaction> list = tservice.getList((String)ses.getAttribute("userid"));
		model.addAttribute("ulist",list);
		return "purchase/transaction-list";
	}
}








