package com.bankmanagement.app.BankManagementApp.service;

import java.util.List;

import com.bankmanagement.app.BankManagementApp.entity.Account;

public interface AccountService {
    Account createAccount(Account account);
    Account getAccountDetailsByAccountNumber(Long accountNumber);
    List<Account> getAccountDetails();
    Account depositAmount(Long accountNumber, Double amount); // ✅ Corrected spelling
    Account withdrawAmount(Long accountNumber, Double amount); // ✅ Corrected spelling
    void closeAccount(Long accountNumber);
}
