package com.pentastagiu.bank_application.commons;

import com.pentastagiu.bank_application.entity.Account;
import com.pentastagiu.bank_application.entity.User;

import java.math.BigDecimal;
import java.util.Random;
import java.util.Scanner;

public class AccountCommons {



    public void accountCreation() {

        User user = new User();
        System.out.println("$$  ACCOUNT CREATION  $$");
        System.out.println("For user: " + user.getUsername());
        String accountNo = accountNumberCreation();
        System.out.println("Account number: " + accountNo);
        System.out.println("Input amount: ");
        Scanner scanner = new Scanner(System.in);
        BigDecimal ammount = scanner.nextBigDecimal();
        System.out.println("Set account type (EUR/RON): ");
        AccountType accountType = null;
        Account account = new Account(user.getUsername(), accountNo, ammount, accountType);

    }

    public String accountNumberCreation(){
        String ro = "RO";
        String bankNumber = "19";
        String bank = "BPEX";
        String chars = "1234567890";
        StringBuilder stringBuilder = new StringBuilder();
        Random random = new Random();
        while (stringBuilder.length() < 11){
            int index = (int)(random.nextFloat() * chars.length());
            stringBuilder.append(chars.charAt(index));
        }
        return ro + bankNumber + bank + stringBuilder.toString();

    }

}
