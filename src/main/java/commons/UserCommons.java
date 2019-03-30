package commons;

import core.entity.User;
import menu.UserMenu;

import java.util.List;
import java.util.Scanner;

public class UserCommons {

    private UserMenu userMenu = new UserMenu();

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


