package game.primary;


import game.fight.Saving;
import game.sql.HeroDatabase;

import java.util.Scanner;

public class GetGame {
    private static Scanner scanner = new Scanner(System.in);

    static void getOptions() {
        String create = "\n"+UserName.getUserName() + ", select next option:\n" +
                "1. Create new Hero \n" +
                "2. Upload saved Hero, and play new game \n" +
                "3. Exit";
        System.out.println(create);
        switch (scanner.nextInt()) {
            case 1:
                HeroDatabase.main();
                break;
            case 2:
                Saving.getSavedCharacteristics();
                break;
            case 3:
                System.err.println("Exit");
                System.exit(0);
                break;
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