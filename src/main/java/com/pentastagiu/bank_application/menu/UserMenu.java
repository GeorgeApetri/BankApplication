package com.pentastagiu.bank_application.menu;

import com.pentastagiu.bank_application.entity.User;

import java.util.Scanner;

public class UserMenu {

    private AccountMenu accountMenu = new AccountMenu();


    public void displayUserMenu(User user) {

        Scanner scanner = new Scanner(System.in);
        int option;
        do {
            System.out.println("1. Account");
            System.out.println("0. Logout");
            option = scanner.nextInt();
            switch (option){
                case 1: accountMenu.displayAccountMenu(user);
                    break;
                case 0:
                    break;
            }
        } while (option != 0);
    }

}
