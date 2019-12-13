package Moving.Fight;

import Main.EnumTestPac.ENUM;
import Main.EnumTestPac.EnumCases;
import Main.Menu;

import java.util.Scanner;

public class PlayAgainOFF {

    public static void again() {
        Scanner scanner = new Scanner(System.in);
        String cases = "\n Would you like to play Again ? " +
                "\n 1. Yes." +
                "\n 2. No (Back to Main Menu)";
        System.out.println(cases);
        switch (scanner.nextInt()) {
            case 1: {
                Level.level_1_1_NOequip();
            }
            case 2: {
                EnumCases.TestEnum(ENUM.FINISHED);
                Menu.mainMenu();
                break;
            }
        }
    }


}
