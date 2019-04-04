package com.pentastagiu.bank_application.commons;

import com.pentastagiu.bank_application.entity.User;

import java.util.List;
import java.util.Scanner;

public class UserCommons {

    public User readUser() {
        System.out.println("Plese input user and password for login!");
        Scanner sc = new Scanner(System.in);
        String username = sc.nextLine();
        String password = sc.nextLine();
        User user = new User(username, password);

        return user;
    }

    public void checkUser(List users, User user) {

        if (UserList.getUserList().contains(user)) {
            System.out.println("Welcome " + user.getUsername() + " !");
            user.setLogged(true);
        } else {
            System.out.println("Incorrect username/password!");
            user.setLogged(false);
        }
    }
}


