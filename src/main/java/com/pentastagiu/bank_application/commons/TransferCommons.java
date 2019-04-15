package com.pentastagiu.bank_application.commons;

import com.pentastagiu.bank_application.entity.Account;
import com.pentastagiu.bank_application.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TransferCommons {

    private static final Logger LOG = LogManager.getLogger(UserList.class);
    private AccountCommons accountCommons = new AccountCommons();

    public void startTransfer(User user) {
        System.out.println("$$$ START TRANSFER PROCEDURE $$$");
        List<Account> ls = createListForTransfer(user);
        displayAccountList(ls);
        System.out.println("Please select account");
        Utils utils = new Utils();
        int option = utils.inputOption();
        System.out.println(ls.get(option));
        BigDecimal amount = selectAmount(ls, option);
        System.out.println("Please select account to transfer amount");
        displayAccountList(ls);
        int option1 = utils.inputOption();
        if (validateAccountForTransfer(ls, option, option1)) {
            ls.get(option).setBalance(ls.get(option).getBalance().subtract(amount));
            ls.get(option1).setBalance(ls.get(option1).getBalance().add(amount));
            System.out.println("$$$ TRANSFER DONE $$$");
            System.out.println(ls.get(option));
            System.out.println(ls.get(option1));
        }
    }

    public boolean validateAccountForTransfer(List<Account> list, int option, int option1) {
        boolean valid;
        if (list.get(option).equals(list.get(option1))) {
            System.out.println("You have selected the same account! " +
                    " Start again transfer procedure!");
            valid = false;
        } else {
            System.out.println("Accounts validated for transfer!");
            valid = true;
        }
        return valid;
    }

    public BigDecimal selectAmount(List<Account> ls, int option) {
        System.out.println("Please select amount");
        Scanner scanner = new Scanner(System.in);
        BigDecimal amount = scanner.nextBigDecimal();
        if (amount.longValue() > ls.get(option).getBalance().longValue()) {
            System.out.println("Amount is bigger than the balance!");
            amount = BigDecimal.valueOf(0);
        } else {
            System.out.println("Amount validated!");
        }
        return amount;
    }

    public void displayAccountList(List<Account> list) {
        int i = 0;
        for (Account account : list) {
            System.out.println(i + ". " + account);
            i++;
        }
    }


    public List<Account> createListForTransfer(User user) {
        AccountType accountType = accountCommons.accountTypeCreation();
        List<Account> transferList;
        if (accountType.equals(AccountType.RON)) {
            checkAccountsNumber(sortByRonType(user));
            transferList = sortByRonType(user);
        } else {
            checkAccountsNumber(sortByEurType(user));
            transferList = sortByEurType(user);
        }
        return transferList;
    }

    public List<Account> sortByRonType(User user) {
        List<Account> ronType = new ArrayList<>();
        for (Account account : user.getAccountsList()) {
            if (account.getAccountType().equals(AccountType.RON)) {
                ronType.add(account);
            }
        }
        return ronType;
    }

    public List<Account> sortByEurType(User user) {
        List<Account> eurType = new ArrayList<>();
        for (Account account : user.getAccountsList()) {
            if (account.getAccountType().equals(AccountType.EUR)) {
                eurType.add(account);
            }
        }
        return eurType;
    }

    public void checkAccountsNumber(List<Account> list) {
        if (list.size() < 2) {
            System.out.println("You need more than 1 account with the same currency type for this operation!!!");
        } else {
            System.out.println("Accounts available for transfer: " + list.size());
            System.out.println();
        }
    }

}
