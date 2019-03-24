import commons.ConsoleMenu;
import commons.FileReadToList;
import commons.UserCommons;

public class Main {

    public static void main(String[] args) {

        ConsoleMenu consoleMenu = new ConsoleMenu();
        FileReadToList fileReadToList = new FileReadToList();
        UserCommons userCommons = new UserCommons();

        userCommons.checkUser(fileReadToList.FileToList(), consoleMenu.displayStartMenu());


    }
}
