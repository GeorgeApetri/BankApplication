package com.pentastagiu.bank_application.menu;

import com.pentastagiu.bank_application.commons.UserCommons;
import com.pentastagiu.bank_application.commons.UserList;
import com.pentastagiu.bank_application.commons.UserLogin;
import com.pentastagiu.bank_application.entity.User;

import java.util.Scanner;

public class ConsoleMenu {

    private UserLogin userLogin = new UserLogin();
    private UserList userList = new UserList();
    private UserCommons userCommons = new UserCommons();


    public void displayStartMenu() {

        userList.FileToList();
        Scanner scanner = new Scanner(System.in);
        int option;
        do {
            System.out.println("$$$ BANK APPLICATION %%%");
            System.out.println("1. Login");
            System.out.println("0. Exit");
            System.out.println("Select option: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    User user = userCommons.readUser();
                    userLogin.validateUser(user);
                    break;
                case 0:
                    System.out.println("Program closed!");
                    break;
            }
        } while (option != 0);

    }
}
