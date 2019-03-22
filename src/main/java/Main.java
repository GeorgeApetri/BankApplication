public class Main {

    public static void main(String[] args) {

        StartMenu st = new StartMenu();
        FileReadToList cu = new FileReadToList();
        User user = new User();
        user.checkUser(cu.FileToList(),st.displayStartMenu());
    }
}
