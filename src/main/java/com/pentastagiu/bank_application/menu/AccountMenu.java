package com.pentastagiu.bank_application.menu;

import com.pentastagiu.bank_application.commons.AccountCommons;
import com.pentastagiu.bank_application.commons.TransferCommons;
import com.pentastagiu.bank_application.commons.Utils;
import com.pentastagiu.bank_application.entity.Account;
import com.pentastagiu.bank_application.entity.User;

import java.util.Scanner;

public class AccountMenu {

    private AccountCommons accountCommons = new AccountCommons();
    private TransferCommons transferCommons = new TransferCommons();

    public void displayAccountMenu(User user) {

        Scanner scanner = new Scanner(System.in);
        int option;
        do {
            System.out.println("1. Create Account");
            System.out.println("2. Display accounts for " + user.getUsername() + " :");
            System.out.println("3. Transfer between accounts");
            System.out.println("0. Back");
            Utils utils = new Utils();
            option = utils.inputOption();
            switch (option) {
                case 1:
                    Account account = accountCommons.accountCreation(user);
                    accountCommons.jsonToFile(accountCommons.accountToJson(account));
                    System.out.println("\n" + "$$ ACCOUNT CREATED $$");
                    break;
                case 2:
                    accountCommons.fileToAccountsList(user);
                    accountCommons.getUserAccounts(user);
                    break;
                case 3:
                    accountCommons.fileToAccountsList(user);
                    transferCommons.startTransfer(user);
//                    select account
//                    validate accounts (we need at least 2) (same currency)
//                    select amount
//                    validate amount less than balance
//                    select account to transfer
//                    update account list from memory
                case 0:
                    break;
            }
        } while (option != 0);
    }
}
