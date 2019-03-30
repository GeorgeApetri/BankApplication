package commons;

import core.entity.User;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserList {

    private static List<User> userList = new ArrayList<>();

    public void FileToList() {

        String filename = "file/users.txt";
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(filename).getFile());
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" ", 2);
                if (parts.length >= 2){
                    String username  = parts[0];
                    String password = parts[1];
                    User user = new User(username, password);
                    userList.add(user);
                } else {
                    System.out.println("Ignoring line " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<User> getUserList() {
        return userList;
    }

}
