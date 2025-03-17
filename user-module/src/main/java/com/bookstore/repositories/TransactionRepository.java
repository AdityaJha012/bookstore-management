package com.bookstore.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bookstore.models.UserTransaction;

public interface TransactionRepository extends JpaRepository<UserTransaction, Integer>
{
	List<UserTransaction> findByUserid(String userid);
}
