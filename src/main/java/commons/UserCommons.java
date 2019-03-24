package commons;

import java.util.List;

public class UserCommons {

    public void checkUser(List list, String username){
        if (list.contains(username)) {
            ConsoleMenu consoleMenu = new ConsoleMenu();
            consoleMenu.displayUserMenu(username);
        } else {
            System.out.println("Wrong username/password!");
        }
    }
}
