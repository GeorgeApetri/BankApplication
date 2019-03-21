public class Main {

    public static void main(String[] args) {

        StartMenu st = new StartMenu();
        Users cu = new Users();
        cu.CheckUser(st.displayStartMenu());
    }
}
