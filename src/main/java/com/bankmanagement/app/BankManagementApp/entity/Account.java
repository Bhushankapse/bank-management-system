package com.bankmanagement.app.BankManagementApp.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "accounts") // ✅ Custom table name de sakte ho
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountNumber; // ✅ Correct Field Name

    @Column(nullable = false)
    private String accountHolderName; // ✅ Correct Field Name

    @Column(nullable = false)
    private Double accountBalance; // ✅ Correct Field Name

    // ✅ Default Constructor
    public Account() {
    }

    // ✅ Parameterized Constructor
    public Account(String accountHolderName, Double accountBalance) {
        this.accountHolderName = accountHolderName;
        this.accountBalance = accountBalance;
    }

    // ✅ Getters and Setters
    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public Double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(Double accountBalance) {
        this.accountBalance = accountBalance;
    }

    // ✅ toString() Method
    @Override
    public String toString() {
        return "Account [accountNumber=" + accountNumber + ", accountHolderName=" + accountHolderName
                + ", accountBalance=" + accountBalance + "]";
    }
}
