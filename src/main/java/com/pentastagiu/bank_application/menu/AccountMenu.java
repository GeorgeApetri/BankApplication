package com.pentastagiu.bank_application.menu;

import com.pentastagiu.bank_application.commons.AccountCommons;
import com.pentastagiu.bank_application.entity.Account;
import com.pentastagiu.bank_application.entity.User;

import java.util.Scanner;

public class AccountMenu {

    private AccountCommons accountCommons = new AccountCommons();

    public void displayAccountMenu(User user) {

        Scanner scanner = new Scanner(System.in);
        int option;
        do {
            System.out.println("1. Create Account");
            System.out.println("2. Display accounts for " + user.getUsername() + " :");
            System.out.println("0. Back");
            option = scanner.nextInt();
            switch (option) {
                case 1:
                    Account account = accountCommons.accountCreation(user);
                    accountCommons.jsonToFile(accountCommons.accountToJson(account));
                    System.out.println("\n" + "$$ ACCOUNT CREATED $$");
                    break;
                case 2:
                    accountCommons.fileToAccountsHashMap();
                    accountCommons.getUserAccounts(AccountCommons.getHashMap(),user);
                    break;
                case 0:
                    break;
            }
        } while (option != 0);
    }
}
