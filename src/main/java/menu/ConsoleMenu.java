package menu;

import commons.UserLogin;

import java.util.Scanner;

public class ConsoleMenu {

    private UserLogin userLogin = new UserLogin();

    public void displayStartMenu(){
        Scanner scanner = new Scanner(System.in);
        int option;
        do{
            System.out.println("$$$ BANK APPLICATION %%%");
            System.out.println("1. Login");
            System.out.println("0. Exit");
            System.out.println("Select option: ");
            option = scanner.nextInt();

            switch (option){
                case 1: userLogin.validateUser();
                    break;
                case 2:
                    break;
            }
        } while (option != 0);

    }
}
