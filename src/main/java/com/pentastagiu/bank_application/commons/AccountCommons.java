package com.pentastagiu.bank_application.commons;

import com.google.gson.Gson;
import com.pentastagiu.bank_application.entity.Account;
import com.pentastagiu.bank_application.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.math.BigDecimal;
import java.util.*;

public class AccountCommons {

    private static final Logger LOG = LogManager.getLogger(UserList.class);

    public Account accountCreation(User user) {

        System.out.println("$$  ACCOUNT CREATION  $$");
        System.out.println("For user: " + user.getUsername());
        String accountNo = accountNumberCreation();
        System.out.println("Account number: " + accountNo);
        AccountType accountType = accountTypeCreation();
        System.out.print("Input amount: ");
        Scanner scanner = new Scanner(System.in);
        BigDecimal ammount = scanner.nextBigDecimal();
        Account account = new Account(user.getUsername(), accountNo, ammount, accountType);
        System.out.println();
        LOG.info("Account: " + account.toString());
        return account;
    }

    public String accountNumberCreation() {
        String ro = "RO";
        String bankNumber = "19";
        String bank = "BPEX";
        String chars = "1234567890";
        StringBuilder stringBuilder = new StringBuilder();
        Random random = new Random();
        while (stringBuilder.length() < 11) {
            int index = (int) (random.nextFloat() * chars.length());
            stringBuilder.append(chars.charAt(index));
        }
        return ro + bankNumber + bank + stringBuilder.toString();

    }

    public AccountType accountTypeCreation() {
        System.out.print("Select currency type (EUR/RON): ");
        Scanner scanner = new Scanner(System.in);
        String option = scanner.nextLine();
        return AccountType.valueOf(option);
    }

    public String accountToJson(Account account) {
        Gson gson = new Gson();
        return gson.toJson(account);
    }

    public void jsonToFile(String accountJson) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src\\main\\resources\\accounts.txt", true))) {
            bufferedWriter.write(accountJson);
            bufferedWriter.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void fileToAccountsList(User user) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("src\\main\\resources\\accounts.txt"))) {
            List<Account> accountList1 = new ArrayList<>();
            String strCurrentLine;
            while ((strCurrentLine = bufferedReader.readLine()) != null) {
                Gson gson = new Gson();
                Account account = gson.fromJson(strCurrentLine, Account.class);
                if (account.getUsername().equals(user.getUsername())) {
                    accountList1.add(account);
                }
            }
            user.setAccountsList(accountList1);
            LOG.info("Account list created!");
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getUserAccounts(User user) {
        System.out.println("$$ ACCOUNTS FOR USER " + user.getUsername() + " ! $$");
        System.out.println();
        for (Account account : user.getAccountsList()) {
            System.out.println(account.toString());
        }
        System.out.println();
    }
}

