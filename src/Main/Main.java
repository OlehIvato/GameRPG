package Main;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        String menu = "Main Menu \n 1. New Game \n 2. Exit";
        System.out.println(menu.trim());
        Scanner scan = new Scanner(System.in);
        switch (scan.nextInt()) {
            case 1: {
                UserName.getName();
                NewGame.createHero();
                break;
            }
            case 2:
                System.err.println("EXIT");
                System.exit(0);
            default:
                System.out.println("Something went wrong");
                menu();
        }
    }
}
