package Main;

import java.util.Scanner;

public class Menu {
    public static void mainMenu() {
        String menu = "           Main Menu \n 1. New Game \n 2. Exit                   ";
        System.out.println(menu.trim());
        Scanner scan = new Scanner(System.in);
        switch (scan.nextInt()) {
            case 1: {
                UserName.NameOfUser();
                NewGame.createHero();
                break;
            }
            case 2: {
                System.err.println("EXIT");
                System.exit(0);
            }
        }
    }
}