package com.bankmanagement.app.BankManagementApp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bankmanagement.app.BankManagementApp.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

}
