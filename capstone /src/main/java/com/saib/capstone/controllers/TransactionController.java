//HTTP_Requests for Transaction
package com.saib.capstone.controllers;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.saib.capstone.config.ApiSuccessPayload;
import com.saib.capstone.models.Transaction;
import com.saib.capstone.services.TransactionService;
import com.saib.capstone.util.Results;

//Controller Annotation for web services API's
@RestController
public class TransactionController
{
	
	
	@Autowired
	TransactionService transactionService;
	
	
	@GetMapping("/transaction")
	public ResponseEntity<ApiSuccessPayload> getAllTransaction() //GET - /Transaction - Get me all details 
	{
        List<Transaction> list=transactionService.getAllTransaction();
		
		ApiSuccessPayload payload=ApiSuccessPayload.build(list, "Transaction Fetched", HttpStatus.OK);
		ResponseEntity<ApiSuccessPayload> response=new ResponseEntity<ApiSuccessPayload>(payload,HttpStatus.OK);
		
		return response;
		
	} 
	
	
	@GetMapping("/transaction/{transactionId}")
	public ResponseEntity<ApiSuccessPayload> getTransactionByTransactionId(@PathVariable long transactionId) //GET - /Transaction/id - Get me details for a single transaction 
	{
		Transaction transaction = transactionService.getTransactionByTransactionId(transactionId);
		
		ApiSuccessPayload payload=ApiSuccessPayload.build(transaction, "Success",HttpStatus.OK);
		ResponseEntity<ApiSuccessPayload> response=new ResponseEntity<ApiSuccessPayload>(payload,HttpStatus.OK);
		return response;
	}
	
	//
	@GetMapping("/transaction/transactionType/{transactionType}")
	public ResponseEntity<ApiSuccessPayload> findTransationByTransactionType(@PathVariable String transactionType) //GET - /Transaction/transactionType - Get me the filtered data only
	{
		List<Transaction> list = transactionService.findTransationByTransactionType(transactionType);
		HttpStatus status=HttpStatus.OK;
		ApiSuccessPayload payload=ApiSuccessPayload.build(list, "Transaction Found",status);
		ResponseEntity<ApiSuccessPayload> response=new ResponseEntity<ApiSuccessPayload>(payload, status);
		return response;
	}
	
	//
	@GetMapping("/transaction/date/{date}")
	public ResponseEntity<ApiSuccessPayload> findTransactionByDate(@RequestParam @DateTimeFormat (iso= DateTimeFormat.ISO.DATE) LocalDate date) //GET - Get me the filtered data only
	{
		List<Transaction> list = transactionService.findTransactionByDate(date);
		
		ApiSuccessPayload payload=ApiSuccessPayload.build(list, "Success",HttpStatus.OK);
		ResponseEntity<ApiSuccessPayload> response=new ResponseEntity<ApiSuccessPayload>(payload,HttpStatus.OK);
		return response;
	}
	
	
	@GetMapping("/transaction/{transactionType}/{date}")
	public ResponseEntity<ApiSuccessPayload> findTransactionByDateAndTransactionType     //GET - Get me the filtered data only
	(@RequestParam @DateTimeFormat (iso= DateTimeFormat.ISO.DATE) LocalDate date,
			@PathVariable String transactionType)
	{
		List<Transaction> list = transactionService.findTransactionByDateAndTransactionType(date,transactionType);
		
		ApiSuccessPayload payload=ApiSuccessPayload.build(list, "Success",HttpStatus.OK);
		ResponseEntity<ApiSuccessPayload> response=new ResponseEntity<ApiSuccessPayload>(payload,HttpStatus.OK);
		return response;
	}
	//
	
	
	@GetMapping("/transaction/all/") //paging
	public ResponseEntity<ApiSuccessPayload> getAllTransaction(@RequestParam int pageNumber,@RequestParam int pageSize)
	{
		List<Transaction> list=transactionService.getAllTransaction(pageNumber, pageSize);
		
		HttpStatus status=HttpStatus.OK;
		ApiSuccessPayload payload=ApiSuccessPayload.build(list, "Transaction Found",status);
		ResponseEntity<ApiSuccessPayload> response=new ResponseEntity<ApiSuccessPayload>(payload, status);
		return response;
		
	}
	
	@GetMapping("/transaction/all/sorted")//sorting
	public ResponseEntity<ApiSuccessPayload> getAllTransaction(@RequestParam int pageNumber,@RequestParam int pageSize,@RequestParam String sortBy)
	{
		List<Transaction> list=transactionService.getAllTransaction(pageNumber, pageSize,sortBy);
		HttpStatus status=HttpStatus.OK;
		ApiSuccessPayload payload=ApiSuccessPayload.build(list, "Transaction Found",status);
		ResponseEntity<ApiSuccessPayload> response=new ResponseEntity<ApiSuccessPayload>(payload, status);
		return response;
		
	}

	
	@PostMapping("/transaction")
	public ResponseEntity<ApiSuccessPayload> addTransaction(@RequestBody Transaction transaction) //POST - /Transaction - Creating a new transaction
	{
		ResponseEntity<ApiSuccessPayload> response=null;
		
		System.out.println(transaction);
		String result=transactionService.addTransaction(transaction);
		if(result.equalsIgnoreCase(Results.SUCCESS))
		{
			ApiSuccessPayload payload=ApiSuccessPayload.build(result, "Transaction created successfully", HttpStatus.CREATED);
			response=new ResponseEntity<ApiSuccessPayload>(payload,HttpStatus.CREATED);
		}
		
		return response;
	
	}
	
	
	@PutMapping("/transaction/{transactionId}")
	public ResponseEntity<ApiSuccessPayload> updateTransaction(@RequestBody Transaction transaction, @PathVariable long transactionId) //PUT - /Transaction/id - Updating an existing transaction 
	{
		String result=transactionService.updateTransaction(transaction, transactionId);
		ApiSuccessPayload payload=ApiSuccessPayload.build(result,result,HttpStatus.OK);
		ResponseEntity<ApiSuccessPayload> response=new ResponseEntity<ApiSuccessPayload>(payload, HttpStatus.OK);
		return response;
	}
	
	
	@DeleteMapping("/transaction/{transactionId}")
	public ResponseEntity<ApiSuccessPayload> deleteTransaction(@PathVariable long transactionId) //DELETE -/Transaction/id - for deleting an transaction from db
	{
		String result=transactionService.deleteTransaction(transactionId);
		ApiSuccessPayload payload=ApiSuccessPayload.build(result,result,HttpStatus.OK);
		ResponseEntity<ApiSuccessPayload> response=new ResponseEntity<ApiSuccessPayload>(payload, HttpStatus.OK);
		return response;
	}
	
}
