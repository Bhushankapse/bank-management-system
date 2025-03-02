package com.bankmanagement.app.BankManagementApp.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankmanagement.app.BankManagementApp.entity.Account;
import com.bankmanagement.app.BankManagementApp.repo.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountRepository repo;

    @Override
    public Account createAccount(Account account) {
        return repo.save(account);
    }

    @Override
    public Account getAccountDetailsByAccountNumber(Long accountNumber) {
        return repo.findById(accountNumber)
                .orElseThrow(() -> new RuntimeException("Account not found"));
    }

    @Override
    public List<Account> getAccountDetails() {
        return repo.findAll();
    }

    @Override
    public Account depositAmount(Long accountNumber, Double amount) { // ✅ Fixed method name
        Account account = repo.findById(accountNumber)
                .orElseThrow(() -> new RuntimeException("Account not found"));
        
        double currentBalance = (account.getAccountBalance() == null) ? 0.0 : account.getAccountBalance();
        account.setAccountBalance(currentBalance + amount);
        
        return repo.save(account);
    }

    @Override
    public Account withdrawAmount(Long accountNumber, Double amount) { // ✅ Fixed method name
        Account account = repo.findById(accountNumber)
                .orElseThrow(() -> new RuntimeException("Account not found"));

        double currentBalance = (account.getAccountBalance() == null) ? 0.0 : account.getAccountBalance();
        if (currentBalance < amount) {
            throw new RuntimeException("Insufficient balance");
        }

        account.setAccountBalance(currentBalance - amount);
        return repo.save(account);
    }

    @Override
    public void closeAccount(Long accountNumber) {
        if (!repo.existsById(accountNumber)) {
            throw new RuntimeException("Account not found");
        }
        repo.deleteById(accountNumber);
    }
}
