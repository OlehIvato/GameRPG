package Fight;

import Main.ChoseNewHero;
import Main.Enum_Case;
import Main.UserName;
import java.util.Scanner;

public class Winning {

    public static void win() {
        String win = "\n\n\n:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::" +
                "\n:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::" +
                "\ncongratulations " + UserName.getUserName() + " you went through three levels and won    " +
                "\n:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::" +
                "\n:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::";
        System.out.println(win.toUpperCase());
        backToMain();
    }

    private static void backToMain() {
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