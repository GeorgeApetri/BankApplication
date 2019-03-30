package commons;

import core.entity.User;
import menu.UserMenu;

public class UserLogin {

    private UserList userList = new UserList();
    private UserCommons userCommons = new UserCommons();
    private UserMenu userMenu = new UserMenu();

    public void validateUser() {
        userList.FileToList();
        User user = userCommons.readUser();
        userCommons.checkUser(UserList.getUserList(), user);
        if (user.isLogged()){
            userMenu.displayUserMenu();
        }
    }
}
