package game.primary;

import java.util.Scanner;

public class UserName {
    private static String userName;

    public static String getUserName() {
        return userName;
    }

    public static void setUserName(String userName) {
        UserName.userName = userName;
    }

    public static String getName() {
        System.out.println("What is your name ? ");
        Scanner scan = new Scanner(System.in);
        userName = scan.nextLine();
        return userName;
    }
}


