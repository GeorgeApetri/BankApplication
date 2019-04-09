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

    private static HashMap<String, Account> hashMap = new HashMap<String, Account>();

    public static HashMap<String, Account> getHashMap() {
        return hashMap;
    }

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
        System.out.print("Set account type (EUR/RON): ");
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

    public void fileToAccountsHashMap() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("src\\main\\resources\\accounts.txt"))) {
            while (bufferedReader.readLine() != null) {
                String line = bufferedReader.readLine();
                Gson gson = new Gson();
                Account account = gson.fromJson(line, Account.class);
                hashMap.put(account.getUsername(), account);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getUserAccounts(HashMap hashMap, User user) {
        System.out.println("$$ ACCOUNTS FOR USER " + user.getUsername() + " ! $$");
        if (hashMap.containsKey(user.getUsername())) ;
        {
            System.out.println(hashMap.get(user.getUsername()).toString());
        }
    }
}

