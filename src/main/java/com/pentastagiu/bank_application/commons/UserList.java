package com.pentastagiu.bank_application.commons;

import com.pentastagiu.bank_application.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserList {

    private static List<User> userList = new ArrayList<>();
    private static final Logger LOG = LogManager.getLogger(UserList.class);

    public void FileToList() {

        String filename = "users.txt";
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(filename).getFile());
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" ", 2);
                if (parts.length >= 2) {
                    String username = parts[0];
                    String password = parts[1];
                    User user = new User(username, password);
                    userList.add(user);
                } else {
                    System.out.println("Ignoring line " + line);
                }
            }
        } catch (IOException e) {
            LOG.catching(e);
        }
        LOG.info("UserList created!");
    }

    public boolean isCorrectFileName(String filename) {

        boolean corectFileName = false;
        try {
            ClassLoader classLoader = getClass().getClassLoader();
            File file = new File(classLoader.getResource(filename).getFile());
            if (filename.equals(file.getCanonicalPath())) {
                corectFileName = true;
            }
        } catch (NullPointerException | IOException e) {
            if (corectFileName = false) {
                try {
                    throw new IncorectFileNameException("Incorrect filename: " + filename);
                } catch (IncorectFileNameException e1) {
                    e1.printStackTrace();
                }
            }
            LOG.catching(e);
        }
        return corectFileName;
    }

    public static List<User> getUserList() {
        return userList;
    }

}
