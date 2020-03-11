package game.Primary;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    public static void menu() {
        try {
            String menu = "Main Menu \n 1. New Game \n 2. Exit";
            System.out.println(menu.trim());
            Scanner scan = new Scanner(System.in);
            switch (scan.nextInt()) {
                case 1:
                    UserName.getName();
                    NewGame.createHero();
                    break;
                case 2:
                    System.err.println("Exit");
                    System.exit(0);
                default:
                    throw new IllegalArgumentException();
            }
        } catch (NullPointerException | InputMismatchException | IllegalArgumentException e) {
            System.out.println("Something went wrong\n");
            menu();
        }
    }
}