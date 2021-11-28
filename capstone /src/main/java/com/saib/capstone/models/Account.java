package com.saib.capstone.models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "account")
public class Account {
	@Id
	
	@Column(name = "account_number")
	private long accountNumber;
	
	@Column(name="name")
	private String name;
	
	@Column(name="gender")
	private String gender;
	
	@Column(name="email")
	private String email;
	
	@Column(name="phone")
	private String phone;
	
	@Column(name="address")
	private String address;
	
	@Column(name="account_type")
	private String accountType;
	
	@Column(name="balance")
	private double balance;
	
	@Column(name="credit_limit")
	private double creditLimit;
	
	@Column(name="creation_date")
	private LocalDateTime creationDate;

	@Column(name="last_updated")
	private LocalDateTime lastUpdated;
	
	@Column(name="status")
	private String status;
	
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Account(long accountNumber, String name, String gender, String email, String phone, String address,
			String accountType, double balance, double creditLimit, LocalDateTime creationDate,
			LocalDateTime lastUpdated, String status) {
		super();
		this.accountNumber = accountNumber;
		this.name = name;
		this.gender = gender;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.accountType = accountType;
		this.balance = balance;
		this.creditLimit = creditLimit;
		this.creationDate = creationDate;
		this.lastUpdated = lastUpdated;
		this.status = status;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getCreditLimit() {
		return creditLimit;
	}

	public void setCreditLimit(double creditLimit) {
		this.creditLimit = creditLimit;
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}

	public LocalDateTime getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(LocalDateTime lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", name=" + name + ", gender=" + gender + ", email=" + email
				+ ", phone=" + phone + ", address=" + address + ", accountType=" + accountType + ", balance=" + balance
				+ ", creditLimit=" + creditLimit + ", creationDate=" + creationDate + ", lastUpdated=" + lastUpdated
				+ ", status=" + status + "]";
	}
	
	

	
	
	
	
}










