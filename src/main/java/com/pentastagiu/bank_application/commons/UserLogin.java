package com.pentastagiu.bank_application.commons;

import com.pentastagiu.bank_application.entity.User;
import com.pentastagiu.bank_application.menu.UserMenu;

public class UserLogin {

    private UserCommons userCommons = new UserCommons();
    private UserMenu userMenu = new UserMenu();
    private User user = userCommons.readUser();

    public void validateUser() {
        userCommons.checkUser(UserList.getUserList(), user);
        if (user.isLogged()){

            userMenu.displayUserMenu();
        }
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
