package com.pentastagiu.bank_application.commons;

import com.pentastagiu.bank_application.entity.User;
import com.pentastagiu.bank_application.menu.UserMenu;

public class UserLogin {

    private UserCommons userCommons = new UserCommons();
    private UserMenu userMenu = new UserMenu();

    public void validateUser(User user) {
        userCommons.checkUser(UserList.getUserList(), user);
        if (user.isLogged()){
            userMenu.displayUserMenu(user);
        }
    }
}
