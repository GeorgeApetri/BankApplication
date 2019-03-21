import java.util.Scanner;

public class StartMenu {

    public String displayStartMenu(){
        System.out.println("Plese input user and password for login!");
        Scanner sc = new Scanner(System.in);
        String username = sc.nextLine();

        return username;
    }
}
