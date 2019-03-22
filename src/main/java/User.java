import java.util.List;

public class User {


    public void displayUserMenu(String username) {

        System.out.println("Welcome " + username + " !");
        System.out.println("1. Log Out.");
    }

    public void checkUser(List list, String username){
        if (list.contains(username)) {
            User user = new User();
            user.displayUserMenu(username);
        } else {
            System.out.println("Wrong username/password!");
        }
    }
}
