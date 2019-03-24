package commons;

import java.util.Scanner;

public class ConsoleMenu {

    public String displayStartMenu(){
        System.out.println("Plese input user and password for login!");
        Scanner sc = new Scanner(System.in);
        String username = sc.nextLine();

        return username;
    }

    public void displayUserMenu(String username){

        Scanner scanner = new Scanner(System.in);
        int option;
        do {
            System.out.println("welcome " + username + " !");
            System.out.println("1. logout");
            System.out.println("0. exit");
            System.out.println("Select menu option: ");
            option = scanner.nextInt();
            switch (option){
                case 1:
                    ConsoleMenu st = new ConsoleMenu();
                    FileReadToList cu = new FileReadToList();
                    UserCommons userCommons = new UserCommons();
                    userCommons.checkUser(cu.FileToList(), st.displayStartMenu());
                    break;
                    //TODO: needs changes
                case 0:
                    break;
//                TODO: future implementation
            }
        } while (option != 0);
    }
}
