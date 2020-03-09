package game.Primary;

import game.sql.HeroDatabase;

import java.util.Scanner;

public class NewGame {
    private static Scanner scanner = new Scanner(System.in);

    static void createHero() {
        System.out.println();
        String create = UserName.getUserName() + " would you like to create new Hero and play game ? \n " +
                "1. Yes \n " +
                "2. No (exit) ";
        System.out.println(create);
        switch (scanner.nextInt()) {
            case 1: {
                HeroDatabase.main();
                break;
            }
            case 2: {
                System.err.println("Exit");
                System.exit(0);
                break;
            }
        }
    }

    public static void backToMain() {
        String cases = "\n\n\n Select option: " +
                "\n   1. Create new Hero and play Again ?  " +
                "\n   2. EXIT ";
        System.out.println(cases);
        switch (scanner.nextInt()) {
            case 1: {
                HeroDatabase.main();
                break;
            }
            case 2: {
                System.err.println(" EXIT ");
                System.exit(0);
                break;
            }
        }
    }


}