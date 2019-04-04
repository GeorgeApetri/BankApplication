package com.pentastagiu.bank_application.menu;

import com.pentastagiu.bank_application.commons.AccountCommons;
import com.pentastagiu.bank_application.commons.UserCommons;

import java.util.Scanner;

public class AccountMenu {

    AccountCommons accountCommons = new AccountCommons();
    UserCommons userCommons = new UserCommons();


    public void displayAccountMenu() {

        Scanner scanner = new Scanner(System.in);
        int option;
        do {
            System.out.println("1. Create Account");
            System.out.println("2. Display accounts for (username): ");
            System.out.println("0. Back");
            option = scanner.nextInt();
            switch (option){
                case 1: accountCommons.accountCreation();
                    break;
                case 2:
                    break;
                case 0:
                    break;
            }
        } while (option != 0);
    }
}
