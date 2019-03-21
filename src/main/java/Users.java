import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Users {


    public void CheckUser(String username) {
        String filename = "C:\\Users\\George\\Desktop\\Pentalog\\HW1\\users.txt";
        UserConsoleMenu userConsoleMenu = new UserConsoleMenu();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;

            while ((line = br.readLine()) != null) {
                if (line.equals(username)) {
                    userConsoleMenu.displayUserMenu(username);
                } else {
                    System.out.println("Wrong username/password!");
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
