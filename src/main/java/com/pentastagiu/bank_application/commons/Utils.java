package com.pentastagiu.bank_application.commons;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Utils {

    public int inputOption() {
        Scanner sc = new Scanner(System.in);
        int option = 0;
        boolean goodData = false;
        while (!goodData) {
            System.out.println("Enter option:");
            try {
                option = sc.nextInt();
                goodData = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input!!! Please insert a number!!!");
                String flush = sc.next();
            }
        }
        return option;
    }
}
