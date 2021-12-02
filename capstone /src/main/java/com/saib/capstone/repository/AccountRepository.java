package com.saib.capstone.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.saib.capstone.models.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account,Long>
{

	List<Account> findAccountByGender(String gender);

}