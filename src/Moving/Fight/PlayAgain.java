package Moving.Fight;

import Main.ChoseNewHero;
import Main.EnumTestPac.ENUM;
import Main.EnumTestPac.EnumCases;
import Main.Menu;

import java.util.Scanner;

public class PlayAgain {

    public static void again() {
        Scanner scanner = new Scanner(System.in);
        String cases = "\n Select option :" +
                "\n 1. Play Again " +
                "\n 2. Create new Hero and play Again" +
                "\n 3 Exit ";
        System.out.println(cases);
        switch (scanner.nextInt()) {
            case 1: {
                Level.level_1_1();
            }
            case 2: {
                ChoseNewHero.main();
                break;
            }
            case 3: {
                EnumCases.TestEnum(ENUM.FINISHED);
                Menu.mainMenu();
                break;
            }
        }
    }

}






