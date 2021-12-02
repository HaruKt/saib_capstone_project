package com.saib.capstone.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.saib.capstone.models.Transaction;

@Repository
public interface TransactionReposetory extends JpaRepository<Transaction,Long>
{
	public List<Transaction> findTransationByTransactionType(String transactionType);
	public List<Transaction> findTransactionByDate(LocalDate date);
	public List<Transaction> findTransactionByDateAndTransactionType(LocalDate date,String transactionType);
}
