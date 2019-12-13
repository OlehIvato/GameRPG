package Main;

import java.util.Scanner;

public class UserName {
    private static String UserNameIs;

    public static String getUserNameIs() {
        return UserNameIs;
    }

    protected static String NameOfUser() {
        System.out.println("What is your name ? ");
        Scanner scan = new Scanner(System.in);

        UserNameIs = scan.nextLine();
        System.out.println("Your name is " + UserNameIs + ".");
        return UserNameIs;

    }
}


