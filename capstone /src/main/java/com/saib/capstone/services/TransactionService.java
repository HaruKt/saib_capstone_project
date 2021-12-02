package com.saib.capstone.services;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


import com.saib.capstone.models.Transaction;
import com.saib.capstone.repository.TransactionReposetory;
import com.saib.capstone.util.Results;

// service Annotation 
@Service
public class TransactionService {
	
	@Autowired
	TransactionReposetory transactionReposetory;

	
		public List<Transaction> getAllTransaction()
		{
			List<Transaction> list=transactionReposetory.findAll();
			return list;
		}
			
		
		public Transaction getTransactionByTransactionId(long transactionId)//by ID
		{
			Optional<Transaction> optional=transactionReposetory.findById(transactionId);
			
			if(optional.isPresent()) {
				return optional.get();
			}
			else {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Transaction with Transaction Number:"+transactionId+"doesn't exist");
			}
			
		}
		
		//filtered by TransactionType
		public List<Transaction> getByTransactionType(String transactionType)
		{
			List<Transaction> transaction=transactionReposetory.findTransationByTransactionType(transactionType);
			return transaction;
		
		}
		//
		//filtered by date
	    public List<Transaction> findTransactionByDate(LocalDateTime date)
		{
			List<Transaction> transaction=transactionReposetory.findTransactionByDate(date);
			return transaction;
			
		} 
	
		
	    //filtered by date & TransactionType
		public List<Transaction> getTransactionByDateTransactionType(LocalDateTime date,String transactionType)
		{
			List<Transaction> transaction=transactionReposetory.findTransactionByDateAndTransactionType(date,transactionType);
			return transaction;
		
		}
		//
		
		//paging
		public List<Transaction> getAllTransaction(Integer pageNo, Integer pageSize){
			Pageable paging = PageRequest.of(pageNo, pageSize);
			
			Page <Transaction> pagedResult = transactionReposetory.findAll(paging);
			int totalElements=pagedResult.getNumberOfElements();
			int total=pagedResult.getTotalPages();
			System.out.println("Total Number of Pages are: "+ total + " and Total Elements are : "+totalElements);
			if(pagedResult.hasContent())
		    {
			   return pagedResult.getContent();
			}
					
			else 
		    {
			   return new ArrayList<Transaction>();
			}
		}
		
		//Sorting
		public List<Transaction> getAllTransaction(Integer pageNo, Integer pageSize, String sortBy){
			Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
			
			Page <Transaction> pagedResult = transactionReposetory.findAll(paging);
			int totalElements=pagedResult.getNumberOfElements();
			int total=pagedResult.getTotalPages();
			System.out.println("Total Number of Pages are: "+ total + " and Total Elements are : "+totalElements);
			if(pagedResult.hasContent())
			{
				return pagedResult.getContent();
			}
					
			else 
			{
				return new ArrayList<Transaction>();
			}
		}
		
		//add new transaction
		public String addTransaction(Transaction transaction)
		{
			String result="";
			Transaction storedTransaction=transactionReposetory.save(transaction);
			if(storedTransaction!=null) {
				result=Results.SUCCESS;
			}
			else {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Transaction not created");
			}
			
			return result;
		}
		
		//update
		public String updateTransaction(Transaction transaction, long transactionId)
		{
			String result="";
			
			transaction.setTransactionId(transactionId);
			Transaction updatedTransaction=transactionReposetory.save(transaction);
			
			if(updatedTransaction!=null)
			{
				result=Results.SUCCESS;
			}
			else
			{
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Record was not updated");
			}
			return result;
			
		}
		
		//delete from the db
		public String deleteTransaction(long transactionId)
		{
			String result="";
			try {
				transactionReposetory.deleteById(transactionId);
			
			
				result=Results.SUCCESS;
				return result;
			}
			catch (Exception e) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
			}
			
		}

	}


