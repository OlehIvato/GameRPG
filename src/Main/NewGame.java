package Main;

import java.util.Scanner;

public class NewGame {

    public static void createHero() {
        System.out.println();
        String create = UserName.getUserName() + " would you like to create new Hero and play game ? \n " +
                "1. Yes \n " +
                "2. No (exit) ";
        System.out.println(create);
        Scanner scan = new Scanner(System.in);
        switch (scan.nextInt()) {
            case 1: {
                ChoseNewHero.main();
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
        Scanner scanner = new Scanner(System.in);
        switch (scanner.nextInt()) {
            case 1: {
                ChoseNewHero.main();
                break;
            }
            case 2: {
                Enum_Case.TestEnum(Enum_Case.ENUM.FINISHED);
                System.err.println(" EXIT ");
                System.exit(0);
                break;
            }
        }
    }


}