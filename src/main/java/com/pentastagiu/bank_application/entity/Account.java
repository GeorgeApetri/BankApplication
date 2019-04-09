package com.pentastagiu.bank_application.entity;

import com.pentastagiu.bank_application.commons.AccountType;

import java.math.BigDecimal;
import java.util.Objects;

public class Account {

    private String username;
    private String accountNumber;
    private BigDecimal balance;
    private AccountType accountType;

    public Account(String username, String accountNumber, BigDecimal balance, AccountType accountType) {
        this.username = username;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.accountType = accountType;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(username, account.username) &&
                Objects.equals(accountNumber, account.accountNumber) &&
                Objects.equals(balance, account.balance) &&
                accountType == account.accountType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, accountNumber, balance, accountType);
    }

    @Override
    public String toString() {
        return "Account{" +
                "username='" + username + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", balance=" + balance +
                ", accountType=" + accountType +
                '}';
    }
}
